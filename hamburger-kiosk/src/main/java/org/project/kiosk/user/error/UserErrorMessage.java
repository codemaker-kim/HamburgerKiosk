package org.project.kiosk.user.error;

public enum UserErrorMessage {
    ALREADY_EXISTS("[ERROR] 이미 존재하는 사용자입니다."),
    WRONG_ID("[ERROR] 잘못된 고유 아이디 입력입니다."),
    NEGATIVE_MONEY("[ERROR] 소지금이 음수여서는 안 됩니다.");

    private final String message;

    UserErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
