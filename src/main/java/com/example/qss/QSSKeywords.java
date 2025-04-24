package com.example.qss; // 请确保包名正确

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class QSSKeywords {

    // *** Updated WIDGETS set ***
    public static final Set<String> WIDGETS = new HashSet<>(Arrays.asList(
            "QAbstractScrollArea", "QCheckBox", "QColumnView", "QComboBox", "QDateEdit", "QDateTimeEdit",
            "QDialog", "QDialogButtonBox", "QDockWidget", "QDoubleSpinBox", "QFrame", "QGroupBox", "QHeaderView",
            "QLabel", "QLineEdit", "QListView", "QListWidget", "QMainWindow", "QMenu", "QMenuBar", "QMessageBox",
            "QProgressBar", "QPushButton", "QRadioButton", "QScrollBar", "QSizeGrip", "QSlider", "QSpinBox",
            "QSplitter", "QStatusBar", "QTabBar", "QTabWidget", "QTableView", "QTableWidget", "QTextEdit",
            "QTimeEdit", "QToolBar", "QToolButton", "QToolBox", "QToolTip", "QTreeView", "QTreeWidget",
            "QWidget"
    ));

    // *** Updated PROPERTIES set ***
    public static final Set<String> PROPERTIES = new HashSet<>(Arrays.asList(
            "alternate-background-color", "background", "background-color", "background-image",
            "background-repeat", "background-position", "background-attachment", "background-clip",
            "background-origin", "border", "border-top", "border-right", "border-bottom", "border-left",
            "border-color", "border-top-color", "border-right-color", "border-bottom-color",
            "border-left-color", "border-image", "border-radius", "border-top-left-radius",
            "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius",
            "border-style", "border-top-style", "border-right-style", "border-bottom-style",
            "border-left-style", "border-width", "border-top-width", "border-right-width",
            "border-bottom-width", "border-left-width", "bottom", "button-layout", "color",
            "dialogbuttonbox-buttons-have-icons", "font", "font-family", "font-size", "font-style",
            "font-weight", "gridline-color", "height", "icon-size", "image", "image-position", "left",
            "lineedit-password-character", "lineedit-password-mask-delay", "margin", "margin-top",
            "margin-right", "margin-bottom", "margin-left", "max-height", "max-width",
            "messagebox-text-interaction-flags", "min-height", "min-width", "opacity", // 注意：移除了 'opacity*' 中的 '*'
            "outline", "outline-color", "outline-offset", "outline-style", "outline-radius",
            "outline-bottom-left-radius", "outline-bottom-right-radius", "outline-top-left-radius",
            "outline-top-right-radius", "padding", "padding-top", "padding-right", "padding-bottom",
            "padding-left", "paint-alternating-row-colors-for-empty-area", "position", "right",
            "selection-background-color", "selection-color", "show-decoration-selected", "spacing",
            "subcontrol-origin", "subcontrol-position", "titlebar-show-tooltips-on-buttons",
            "widget-animation-duration", "text-align", "text-decoration", "top", "width"
    ));

    // *** Updated SUB_CONTROLS set ***
    public static final Set<String> SUB_CONTROLS = new HashSet<>(Arrays.asList(
            "add-line", "add-page", "branch", "chunk", "close-button", "corner", "down-arrow", "down-button",
            "drop-down", "float-button", "groove", "indicator", "handle", "icon", "item", "left-arrow",
            "left-corner", "menu-arrow", "menu-button", "menu-indicator", "right-arrow", "pane",
            "right-corner", "scroller", "section", "separator", "sub-line", "sub-page", "tab", "tab-bar",
            "tear", "tearoff", "text", "title", "up-arrow", "up-button"
    ));

    // *** Updated PSEUDO_STATES set ***
    public static final Set<String> PSEUDO_STATES = new HashSet<>(Arrays.asList(
            "active", "adjoins-item", "alternate", "bottom", "checked", "closable", "closed", "default",
            "disabled", "editable", "edit-focus", "enabled", "exclusive", "first", "flat", "floatable",
            "focus", "has-children", "has-siblings", "horizontal", "hover", "indeterminate", "last", "left",
            "maximized", "middle", "minimized", "movable", "no-frame", "non-exclusive", "off", "on",
            "only-one", "open", "next-selected", "pressed", "previous-selected", "read-only", "right",
            "selected", "top", "unchecked", "vertical", "window"
    ));

    // *** VALUE_KEYWORDS kept as is (no new list provided) ***
    public static final Set<String> VALUE_KEYWORDS = new HashSet<>(Arrays.asList(
            "red", "blue", "green", "black", "white", "transparent",
            "bold", "italic", "underline", "center", "left", "right",
            "solid", "dashed", "dotted"
            // Add more value keywords here
    ));


    // *** COLOR_PROPERTIES kept as is (adjust if needed) ***
    public static final Set<String> COLOR_PROPERTIES = new HashSet<>(Arrays.asList(
            "color", "background-color", "border-color", "alternate-background-color",
            "selection-background-color", "selection-color", "gridline-color", "outline-color"
            // Add more known color properties if necessary
    ));

    // --- Getter methods remain the same ---
    public static Set<String> getWidgets() {
        return Collections.unmodifiableSet(WIDGETS);
    }

    public static Set<String> getProperties() {
        return Collections.unmodifiableSet(PROPERTIES);
    }

    public static Set<String> getSubControls() {
        return Collections.unmodifiableSet(SUB_CONTROLS);
    }

    public static Set<String> getPseudoStates() {
        return Collections.unmodifiableSet(PSEUDO_STATES);
    }

    public static Set<String> getValueKeywords() {
        return Collections.unmodifiableSet(VALUE_KEYWORDS);
    }

    // Optional: Getter for color properties if needed elsewhere
    public static Set<String> getColorProperties() {
        return Collections.unmodifiableSet(COLOR_PROPERTIES);
    }
}