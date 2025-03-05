package org.project.kiosk.user.error;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() { this(UserErrorMessage.NOT_FOUND.getMessage()); }
}
