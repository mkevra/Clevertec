package ru.clevertec.shop.exceptions;

public class NoSuchProductException extends Throwable {
    @Override
    public String getMessage() {
        return "There is no product with provided ID";
    }
}
