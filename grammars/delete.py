import os
import sys
import logging
import shutil
# Configure basic logging
logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')

def delete_files_by_basename(target_directory: str, allowed_basenames: set[str], enable_real_delete: bool = False,remove_dir:bool = False):
    """
    Deletes files in target_directory if their filename (without extension)
    is NOT in the allowed_basenames set. Skips directories.

    Args:
        target_directory (str): Path to the directory to scan.
        allowed_basenames (set[str]): A set containing allowed filenames WITHOUT extensions.
        enable_real_delete (bool): If True, performs deletion. Defaults to False (simulation).

    Returns:
        tuple[int, int]: Number of files deleted, Number of errors during deletion.
                         Returns (-1, -1) if initial validation fails.
                         :param target_directory:
                         :param allowed_basenames:
                         :param enable_real_delete:
                         :param remove_dir:
    """
    if not os.path.isdir(target_directory):
        logging.error(f"Target directory '{target_directory}' not found or is not a directory.")
        return -1, -1



    target_abs_path = os.path.abspath(target_directory)
    logging.info(f"Scanning: {target_abs_path}")
    logging.info(f"Allowed basenames count: {len(allowed_basenames)}")
    if not enable_real_delete:
        logging.info("Mode: Simulation (no files will be deleted)")
    else:
        logging.warning("Mode: REAL DELETION ENABLED")
        # Safety check
        dangerous_paths = ['/', os.path.expanduser("~")]
        if sys.platform.startswith('win'):
            import string
            dangerous_paths.extend([f"{d}:\\" for d in string.ascii_uppercase])
        if target_abs_path in [os.path.abspath(p) for p in dangerous_paths]:
            logging.error(f"Safety Error: Cannot run real deletion in potentially dangerous path: {target_abs_path}")
            return -1, -1

    deleted_count = 0
    error_count = 0
    for root, dirs, files in os.walk(target_abs_path):
        # We only care about files in this version
        for filename in files:
            try:
                # Get filename without extension
                basename = os.path.splitext(filename)[0]
                full_path = os.path.join(root, filename)

                if basename not in allowed_basenames:
                    logging.info(f"[-] To be deleted (basename '{basename}' not in set): {full_path}")
                    if enable_real_delete:
                        try:
                            os.remove(full_path)
                            logging.info("    └── Deleted!")
                            deleted_count += 1
                        except OSError as e:
                            logging.error(f"    └── FAILED to delete: {e}")
                            error_count += 1
                else:
                    # Optionally log kept files, can be commented out for less noise
                    # logging.info(f"[+] Keep (basename '{basename}' in set): {full_path}")
                    pass # File is in the set, do nothing

            except Exception as e:
                logging.error(f"Error processing file '{filename}' in '{root}': {e}")
                error_count += 1

    logging.info(f"Scan complete. Files deleted: {deleted_count}, Errors: {error_count}")
    return deleted_count, error_count

# --- Example Usage based on your input ---
if __name__ == "__main__":
    # Define your sets of basenames
    psi = {"QSSFileImpl", "QSSElementType", "QSSPsiElement", "QSSTokenType"}
    parser = {"QSSParserDefinition"}
    lexer = {"idea-flex", "jflex-1.9.2","QSSLexerAdapter"}  # Corrected potential typo 'idea-flex '
    highlighting = {"QSSSyntaxHighlighter", "QSSSyntaxHighlighterFactory","QSSAnnotator"}
    qss = {"QSSLanguage", "QSSKeywords", "QSSFileType", "QSSContentUtil",
           "QSSCompletionContributor", "QSSCommenter", "QSSColonTypedHandler",
           "QSSBraceMatcher"}
    util = {"Color","ColorDebugUtil"}

    # Merge all sets into one whitelist set
    # The `|` operator is the union operator for sets
    master_whitelist_basenames = psi | parser | lexer | highlighting | qss | util

    # --- Configure ---
    # <<< --- IMPORTANT: Set this to your actual target directory! --- >>>
    target_dir = "C:\\Users\\sammiler\\IdeaProjects\\QssEditor\\src\\main\\java\\com\\example\\qss" # Use a test directory first!

    # --- Run ---
    # 1. Simulation Run (Highly Recommended First)
    print("\n--- Running Simulation ---")
    deleted_sim, errors_sim = delete_files_by_basename(target_dir, master_whitelist_basenames, enable_real_delete=True)
    deleted_sim1, errors_sim1 = delete_files_by_basename("C:\\Users\\sammiler\\IdeaProjects\\QssEditor\\gen", "", enable_real_delete=True,remove_dir=True)
    deleted_sim2, errors_sim2 = delete_files_by_basename("C:\\Users\\sammiler\\IdeaProjects\\QssEditor\\build", "", enable_real_delete=True,remove_dir=True)
    print(f"Simulation complete. Would delete: {deleted_sim}, Errors encountered (during simulation): {errors_sim}")

    # 2. Real Deletion (Only run if simulation is correct)
    # print("\n--- Preparing for Real Deletion ---")
    # # Uncomment the next line to run the actual deletion after reviewing the simulation
    # # deleted_real, errors_real = delete_files_by_basename(target_dir, master_whitelist_basenames, enable_real_delete=True)
    # # if deleted_real != -1: # Check if deletion wasn't cancelled or failed validation
    # #     print(f"Real deletion complete. Files deleted: {deleted_real}, Errors: {errors_real}")
    # # else:
    # #     print("Real deletion did not proceed or failed initial checks.")

    print("\nReview the simulation output above carefully.")
    print("If correct, uncomment the 'Real Deletion' section in the script and run again.")
    print("!!! BACKUP YOUR DIRECTORY BEFORE REAL DELETION !!!")