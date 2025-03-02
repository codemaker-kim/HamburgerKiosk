package org.project.kiosk.util.error;

import java.io.FileNotFoundException;

public class ProductFileNotFoundException extends RuntimeException {
    public ProductFileNotFoundException(String message) {
        super(message);
    }

    public ProductFileNotFoundException() { this(ErrorMessage.PRODUCT_FILE_NOT_FOUND.getMessage()); }
}
