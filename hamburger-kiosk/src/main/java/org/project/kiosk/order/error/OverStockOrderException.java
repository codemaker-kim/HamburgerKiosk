package org.project.kiosk.order.error;

public class OverStockOrderException extends RuntimeException {
    public OverStockOrderException(String message) {
        super(message);
    }

    public OverStockOrderException() { this(OrderErrorMessage.OVER_STOCK.getMessage()); }
}
