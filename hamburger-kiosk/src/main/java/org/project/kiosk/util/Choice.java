package org.project.kiosk.util;

public enum Choice {
    EXIT("0"),
    JOIN_MANAGER("1"),
    ACCESS_MANAGER("2"),
    JOIN_MEMBER("3"),
    ACCESS_MEMBER("4");

    private final String code;

    Choice(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
