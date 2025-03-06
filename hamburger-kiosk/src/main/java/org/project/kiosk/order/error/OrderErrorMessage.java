package org.project.kiosk.order.error;

public enum OrderErrorMessage {
    WRONG_FORM("[ERROR] 올바르지 않은 형식으로 입력했습니다."),
    OVER_STOCK("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다.");

    private final String message;

    OrderErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
