package ru.clevertec.shop.file_utils;

import ru.clevertec.shop.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadUtil {
    public static List<Integer> readFileCards(String filePath) {
        List<Integer> cards = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                int num = Integer.parseInt(line);
                cards.add(num);
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public static List<Product> readFileProduct(String filePath) {
        List<Product> products = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] arr;
            while (line != null) {
                arr = line.split(";");
                products.add(new Product(arr[0], Double.parseDouble(arr[1]), arr[2]));
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
