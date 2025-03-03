package org.project.kiosk.product.domain;

public enum Category {
    BURGER("햄버거"),
    SIDE("사이드"),
    DRINK("음료수"),
    SET("세트");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
