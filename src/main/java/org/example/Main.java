package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Криптоанализатор!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Зашифровать");
            System.out.println("2 - Расшифровать используя ключ");
            System.out.println("3 - Расшифровать методом \"BruteForce\"");
            System.out.println("0 - Выход");
            System.out.print("> ");

            String menuInput = scanner.nextLine();

            switch (menuInput) {
                case "1" -> encryption(scanner);
                case "2" -> decryption(scanner);
                case "3" -> System.out.println("Метод 3");
                case "0" -> {
                    System.out.println("Завершение программы...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неизвестная команда");

            }
        }
    }

    private static void encryption(Scanner scanner) {

        System.out.println("Напишите путь к файлу, который хотите зашифровать и ключ для шифровки");
        System.out.println("Или оставьте поля пустыми для запуска примера шифрования:");
        System.out.print("Введите путь к файлу > ");
        String filePath = scanner.nextLine();

        if (filePath.isEmpty()) {
            System.out.println("Запущен пример шифрования...");
            // пример шифрования
            return;
        }

        File inputFile = new File(filePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Файл не найден или недопустимый путь: " + filePath);
            return;
        }

        int key = 0;
        System.out.print("Введите ключ для шифровки > ");
        String keyInput = scanner.nextLine();
        if (!keyInput.isEmpty()) {
            try {
                key = Integer.parseInt(keyInput);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат ключа. Попробуйте снова.");
                return;
            }
        } else {
            System.out.println("Ключ не введен. Будет использован ключ по умолчанию.");
            key = 3;
            // шифрование со ключом по умолчанию
        }

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\elpep\\test\\dest.txt"))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String encryptedLine = Encrypt.decrypt(line, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decryption(Scanner scanner) {

        System.out.println("Напишите путь к файлу, который хотите расшифровать и ключ для расшифровки");
        System.out.println("Или оставьте поля пустыми для запуска примера дешифровки:");
        System.out.print("Введите путь к файлу > ");
        String filePath = scanner.nextLine();

        if (filePath.isEmpty()) {
            System.out.println("Запущен пример дешифровки...");
            // пример дешифровки
            return;
        }

        File inputFile = new File(filePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Файл не найден или недопустимый путь: " + filePath);
            return;
        }

        int key = 0;
        System.out.print("Введите ключ для дешифровки > ");
        String keyInput = scanner.nextLine();
        if (!keyInput.isEmpty()) {
            try {
                key = Integer.parseInt(keyInput);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный формат ключа. Попробуйте снова.");
                return;
            }
        } else {
            System.out.println("Ключ не введен, возврат в главное меню...");
        }
        //  написать логику чтения файла и дешифровки
    }
}