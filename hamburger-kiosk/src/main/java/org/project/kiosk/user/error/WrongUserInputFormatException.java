package org.project.kiosk.user.error;

public class WrongUserInputFormatException extends RuntimeException {
    public WrongUserInputFormatException(String message) {
        super(message);
    }

    public WrongUserInputFormatException() { this(UserErrorMessage.WRONG_INPUT.getMessage()); }
}
