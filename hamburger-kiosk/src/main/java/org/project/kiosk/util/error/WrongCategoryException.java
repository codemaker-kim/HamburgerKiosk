package org.project.kiosk.util.error;

import org.project.kiosk.product.domain.Category;

public class WrongCategoryException extends RuntimeException {
    public WrongCategoryException(String message) {
        super(message);
    }

    public WrongCategoryException() { this(ErrorMessage.WRONG_CATEGORY.getMessage()); }
}
