package com.example.qss;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

public final class QssIcons { // Use 'final' and private constructor for utility class
    private QssIcons() {
        // Private constructor to prevent instantiation
    }

    // Load the icon.
    // The path "/icons/qssFile.svg" is relative to the 'resources' root.
    // Passing QssIcons.class helps IconLoader find the correct classloader.
    public static final Icon FILE = IconLoader.getIcon("/icons/qssIcon.svg", QssIcons.class);

    // If you want separate icons for light/dark themes (using SVG is often sufficient):
    // IconLoader automatically checks for '/icons/qssFile_dark.svg' if needed.
}