package org.project.kiosk.product.error;

public enum ProductErrorMessage {
    NOT_FOUND("[ERROR] 존재하지 않는 상품입니다.");

    private final String message;

    ProductErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
