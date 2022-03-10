package ru.clevertec.shop.menu;

import ru.clevertec.shop.entities.DiscountCard;
import ru.clevertec.shop.entities.Product;
import ru.clevertec.shop.exceptions.InvalidCardNumberException;
import ru.clevertec.shop.exceptions.NoSuchProductException;
import ru.clevertec.shop.file_utils.FileReadUtil;
import ru.clevertec.shop.file_utils.PrintReceipt;
import ru.clevertec.shop.utils.Order;


import java.util.List;
import java.util.Scanner;


public class MainMenu {
    public static void run() throws InvalidCardNumberException, NoSuchProductException {
        Order order = new Order();
        List<Product> product = FileReadUtil.readFileProduct("Products.txt");
        List<Integer> card = FileReadUtil.readFileCards("CardNumbers.txt");
        System.out.println("Список товаров:");
        int index = 1;
        for (Product p : product) {
            System.out.println(index++ + ". " + p);
        }
        Scanner scan = new Scanner(System.in);
        int choiceMainMenu = 1;
        do {
            try {
                System.out.println(
                        "Выберите товар из списка по индексу или нажмите -1 для оформления заказа:");
                choiceMainMenu = scan.nextInt();
                if (choiceMainMenu <= index && choiceMainMenu >= 0) {
                    System.out.println("Введите количество:");
                    int count = scan.nextInt();
                    order.addOrder(product.get(choiceMainMenu), count);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(
                        "Вы выбрали индекс, которого нет в списке. Выберите товар согласно индексу.");
            }
        } while (choiceMainMenu <= index && choiceMainMenu >= 0);
        order.addOrder2();
        System.out.println(
                "Введите последние четыре цифры скидочной карты или нажмите -1 для формирования чека:");
        int cardNumber = scan.nextInt();
        for (Integer numb : card) {
            if (numb.equals(cardNumber)) {
                order.addDiscount(new DiscountCard(cardNumber, 2));
                break;
            }
        }
        String text = "ЧЕК\n" + order.getReceipt() + "\n" + "Итого к оплате: " + String.format("%.2f", order.getSumForPay()) + "\n" +
                "--------------------------------" + "\n";
        PrintReceipt.writeToFile("Receipt.txt", text);
        System.out.println(order.getReceipt() + "\n" + "Итого к оплате: " + String.format("%.2f", order.getSumForPay()));
    }

}


