package org.project.kiosk.order.error;

public class WrongOrderFormatException extends IllegalArgumentException{
    public WrongOrderFormatException(String Message){ super(Message); }

    public WrongOrderFormatException(){ this(OrderErrorMessage.WRONG_FORM.getMessage()); }
}
