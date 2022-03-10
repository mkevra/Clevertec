package ru.clevertec.shop.entities;

import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private String sale;

    public Product(String name, double price, String sale) {
        this.name = name;
        this.price = price;
        this.sale = sale;
    }

    public double getPrice() {
        return price;
    }

    public String getSale() {
        return sale;
    }

    @Override
    public String toString() {
        return name + ". Цена " + price + ". По акции: " + sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(name,
                product.name) && Objects.equals(sale, product.sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, sale);
    }
}
