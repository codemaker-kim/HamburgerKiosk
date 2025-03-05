package org.project.kiosk.file.parse;

public enum ElementIndex {
    NAME_INDEX(0),
    PRICE_INDEX(1),
    QUANTITY_INDEX(2),
    DESCRIPTION_INDEX(3),
    CATEGORY_INDEX(4);

    private final int index;

    ElementIndex(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }
}
