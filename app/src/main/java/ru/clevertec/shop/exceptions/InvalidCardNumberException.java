package ru.clevertec.shop.exceptions;

public class InvalidCardNumberException extends Throwable {
    @Override
    public String getMessage() {
        return "Number length must be 4!";
    }
}
