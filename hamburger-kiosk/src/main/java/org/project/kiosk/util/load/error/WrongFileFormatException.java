package org.project.kiosk.util.load.error;

public class WrongFileFormatException extends RuntimeException {
    public WrongFileFormatException(String message) {
        super(message);
    }

    public WrongFileFormatException() { this(FileLoadErrorMessage.WRONG_FILE_FORMAT.getMessage()); }
}
