package ru.clevertec.shop.entities;

public class ProductOrder {
    private final Product product;
    private final int countForOrder;

    public ProductOrder(Product product, int countForOrder) {
        this.product = product;
        this.countForOrder = countForOrder;
    }

    public double getSum() {
        if (countForOrder > 5 && product.getSale().equals("да")) {
            return product.getPrice() * countForOrder * (1 - 0.1);
        } else {
            return product.getPrice() * countForOrder;
        }
    }

    @Override
    public String toString() {
        if (countForOrder > 5 && product.getSale().equals("да")) {
            return product + ". Количество " + countForOrder
                    + ". Сумма с учётом скидки по акции " + getSum();
        } else {
            return product.toString() + ". Количество " + countForOrder + ". Сумма " + getSum();
        }
    }
}
