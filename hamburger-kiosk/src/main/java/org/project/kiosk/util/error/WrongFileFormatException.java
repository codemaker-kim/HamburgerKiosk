package org.project.kiosk.util.error;

public class WrongFileFormatException extends RuntimeException {
    public WrongFileFormatException(String message) {
        super(message);
    }

    public WrongFileFormatException() { this(ErrorMessage.WRONG_FILE_FORMAT.getMessage()); }
}
