package org.project.kiosk.user.error;

public class WrongIdFormatException extends IllegalArgumentException {
    public WrongIdFormatException(String message) {
        super(message);
    }

    public WrongIdFormatException() { this(UserErrorMessage.WRONG_ID.getMessage()); }
}
