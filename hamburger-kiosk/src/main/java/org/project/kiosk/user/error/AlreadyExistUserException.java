package org.project.kiosk.user.error;

public class AlreadyExistUserException extends IllegalArgumentException {
    public AlreadyExistUserException(String message) {
        super(message);
    }

    public AlreadyExistUserException() { this(UserErrorMessage.ALREADY_EXISTS.getMessage()); }
}
