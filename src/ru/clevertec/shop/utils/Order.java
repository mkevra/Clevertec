package ru.clevertec.shop.utils;

import ru.clevertec.shop.entities.DiscountCard;
import ru.clevertec.shop.entities.Product;
import ru.clevertec.shop.entities.ProductOrder;


import java.util.*;

public class Order {
    private DiscountCard discountCard;
    List<ProductOrder> productOrders = new ArrayList<>();
    private final Map<Product, Integer> productIntegerMap = new LinkedHashMap<>();

    public void addOrder(Product product, int count) {
        if (!productIntegerMap.containsKey(product)) {
            productIntegerMap.put(product, count);
        } else {
            int temp;
            temp = count;
            productIntegerMap.put(product, productIntegerMap.get(product) + temp);
        }
    }

    public void addOrder2() {
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            productOrders.add(new ProductOrder(key, value));
        }
    }

    public void addDiscount(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public String getReceipt() {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (ProductOrder productOrder : productOrders) {
            index++;
            builder.append(index)
                    .append(". ")
                    .append(productOrder.toString())
                    .append("\n");
            double additionalDiscount = calcDiscount(productOrder.getSum(), this.discountCard);
            if (Double.compare(additionalDiscount, 0) > 0) {
                builder.append("Дополнительная скидка по дисконтной карте: ")
                        .append(additionalDiscount)
                        .append("\n");
            }
        }
        return builder.toString();
    }

    private double calcDiscount(double sum, DiscountCard discountCard) {
        if (discountCard != null) {
            return calcDiscount(sum, discountCard.getDiscount());

        }
        return 0;
    }

    public double calcDiscount(double sum, int discount) {
        return sum * (discount * 1.0 / 100);
    }

    public double getSumForPay() {
        double sum = 0;
        for (ProductOrder productOrder : productOrders) {
            sum += productOrder.getSum();
        }
        return calcSumWithDiscount(sum, calcDiscount(sum, this.discountCard));
    }

    public double calcSumWithDiscount(double sum, double discountSum) {
        if (Double.compare(discountSum, 0) > 0) {
            return sum - discountSum;
        }
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return discountCard.equals(order.discountCard) && productOrders.equals(order.productOrders) && productIntegerMap.equals(order.productIntegerMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCard, productOrders, productIntegerMap);
    }
}
