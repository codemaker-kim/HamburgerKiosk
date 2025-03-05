package org.project.kiosk.util;

public enum Separator {
    COMMA(",");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
