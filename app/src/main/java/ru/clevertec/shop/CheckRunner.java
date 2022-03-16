package ru.clevertec.shop;


import ru.clevertec.shop.exceptions.InvalidCardNumberException;
import ru.clevertec.shop.exceptions.NoSuchProductException;
import ru.clevertec.shop.menu.MainMenu;


public class CheckRunner {
    public static void main(String[] args) throws InvalidCardNumberException, NoSuchProductException {
        MainMenu.run();
    }

}
