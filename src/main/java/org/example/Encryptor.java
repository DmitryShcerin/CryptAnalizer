package org.example;

import java.io.*;
import java.util.Scanner;

public class Encryptor {

    public static void encryptFile(Scanner scanner) {

        System.out.println("Напишите путь к файлу, который хотите зашифровать и ключ для шифровки");
        System.out.println("Или оставьте поля пустыми для запуска примера шифрования:");
        System.out.print("Введите путь к файлу > ");
        String filePath = scanner.nextLine();
        String encryptedFilePath = "C:\\Users\\elpep\\test\\encr.txt";

        if (filePath.isEmpty()) {
            runDemoEncryption();
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
            key = 4;
        }

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(encryptedFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String encryptedLine = Caesar.encrypt(line, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }
            System.out.println("Файл успешно зашифрован с ключом \"" + key + "\" и записан в файл - " + encryptedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runDemoEncryption(){
        System.out.println("Запущен пример шифрования...");

        String demoTextFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\demo_to_encrypt_text.txt";
        String encryptedDemoTextFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\encrypted_demo_text.txt";
        int key = 15;
        System.out.println("Ключ используемый в примере шифрования: " + key);

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(demoTextFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(encryptedDemoTextFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String encryptedLine = Caesar.encrypt(line, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }
            System.out.println("Файл успешно зашифрован с ключом \"" + key + "\" и записан в файл - " + encryptedDemoTextFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
