package org.project.kiosk.file.load.error;

public class WrongCategoryException extends RuntimeException {
    public WrongCategoryException(String message) {
        super(message);
    }

    public WrongCategoryException() { this(FileLoadErrorMessage.WRONG_CATEGORY.getMessage()); }
}
