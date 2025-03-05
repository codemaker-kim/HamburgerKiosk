package org.project.kiosk.util.load.error;

public class ProductFileNotFoundException extends RuntimeException {
    public ProductFileNotFoundException(String message) {
        super(message);
    }

    public ProductFileNotFoundException() { this(FileLoadErrorMessage.PRODUCT_FILE_NOT_FOUND.getMessage()); }
}
