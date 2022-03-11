package ru.clevertec.shop.entities;

import java.util.Objects;

public class DiscountCard {
    private final int cardNumber;
    private final int discount;

    public DiscountCard(int cardNumber, int discount) {
        this.cardNumber = cardNumber;
        this.discount = discount;
    }

//    public void setCardNumber(int cardNumber) throws InvalidCardNumberException {
//        if (!cardNumber.matches("\\d{4}")) throw new InvalidCardNumberException();
//        this.cardNumber = cardNumber;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountCard)) return false;
        DiscountCard that = (DiscountCard) o;
        return cardNumber == that.cardNumber && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, discount);
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "cardNumber=" + cardNumber +
                ", discount=" + discount +
                '}';
    }

    public int getDiscount() {
        return discount;
    }
}

