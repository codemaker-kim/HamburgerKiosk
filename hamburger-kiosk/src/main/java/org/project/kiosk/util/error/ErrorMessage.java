package org.project.kiosk.util.error;

public enum ErrorMessage {
    PRODUCT_FILE_NOT_FOUND("상품 등록 파일을 찾을 수 없습니다."),
    WRONG_FILE_FORMAT("상품 파일 작성 양식이 잘못되었습니다."),
    WRONG_CATEGORY("존재하지 않는 카테고리입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
