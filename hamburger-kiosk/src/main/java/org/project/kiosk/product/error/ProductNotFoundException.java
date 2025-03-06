package org.project.kiosk.product.error;

public class ProductNotFoundException extends IllegalArgumentException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() { this(ProductErrorMessage.NOT_FOUND.getMessage()); }
}
