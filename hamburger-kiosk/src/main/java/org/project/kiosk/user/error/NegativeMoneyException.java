package org.project.kiosk.user.error;

public class NegativeMoneyException extends IllegalArgumentException {
    public NegativeMoneyException(String message) {
        super(message);
    }

    public NegativeMoneyException() { this(UserErrorMessage.NEGATIVE_MONEY.getMessage()); }
}
