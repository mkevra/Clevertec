package ru.clevertec.shop.file_utils;

import java.io.FileWriter;
import java.io.IOException;

public class PrintReceipt {
    public static void writeToFile(String nameFile, String text) {
        try (FileWriter fileWriter = new FileWriter(nameFile, true)) {
            fileWriter.write(text);
            fileWriter.append('\n');
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом" + e);
        }
    }

}
