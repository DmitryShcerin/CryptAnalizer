package org.example;

import java.io.*;
import java.util.Scanner;

public class Decryptor {

    public static void decryptFile(Scanner scanner) {

        System.out.println("Напишите путь к файлу, который хотите расшифровать и ключ для расшифровки");
        System.out.println("Или оставьте поля пустыми для запуска примера дешифровки:");
        System.out.print("Введите путь к файлу > ");
        String encryptedFilePath = scanner.nextLine();
        String decryptedFilePath = "C:\\Users\\elpep\\test\\decr.txt";

        if (encryptedFilePath.isEmpty()) {
            runDemoDecryption();
            return;
        }

        File inputFile = new File(encryptedFilePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Файл не найден или недопустимый путь: " + encryptedFilePath);
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

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(encryptedFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(decryptedFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String decryptedLine = Caesar.decrypt(line, key);
                bufferedWriter.write(decryptedLine);
                bufferedWriter.newLine();
            }
            System.out.println("Файл успешно расшифрован с ключом \"" + key + "\" и записан в файл - " + decryptedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void runDemoDecryption(){
        System.out.println("Запущен пример дешифровки...");

        String demoToDecryptTextFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\demo_to_decrypt_text.txt";
        String decryptedDemoTextFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\decrypted_demo_text.txt";
        int key = 15;
        System.out.println("Ключ используемый в примере шифрования: " + key);

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(demoToDecryptTextFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(decryptedDemoTextFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String encryptedLine = Caesar.decrypt(line, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }
            System.out.println("Файл успешно расшифрован с ключом \"" + key + "\" и записан в файл - " + decryptedDemoTextFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
