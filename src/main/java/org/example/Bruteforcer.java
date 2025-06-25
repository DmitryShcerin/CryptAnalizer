package org.example;

import java.io.*;
import java.util.Scanner;

public class Bruteforcer {

    public static void bruteforceFile(Scanner scanner) {
        System.out.println("Напишите путь к файлу, который хотите расшифровать Брутфорсом");
        System.out.println("Или оставьте поле пустым, чтобы использовать файл по умолчанию");
        System.out.print("Введите путь к файлу > ");
        String encryptedFilePath = scanner.nextLine();
        String decryptedByBruteForceFilePath = "C:\\Users\\elpep\\test\\bruteforce_result.txt";

        if (encryptedFilePath.isEmpty()) {
            runDemoBruteforce();
            return;
        }

        File inputFile = new File(encryptedFilePath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Файл не найден или недопустимый путь: " + encryptedFilePath);
            return;
        }

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(encryptedFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(decryptedByBruteForceFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                DecryptionResult result = Caesar.decryptByBruteForce(line);
                String decryptedLine = result.getDecryptedText();
                int usedKey = result.getKey();
                bufferedWriter.write(decryptedLine);
                bufferedWriter.newLine();
                System.out.println("Ключ, которым был зашифрован текст: " + usedKey);
            }
            System.out.println("Брутфорс завершен. Результаты записаны в файл: " + decryptedByBruteForceFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void runDemoBruteforce(){
        System.out.println("Запущен пример дешифровки...");

        String demoToBruteForceTextFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\demo_to_bruteforce_text.txt";
        String demoDecryptedByBruteFilePath = "C:\\Users\\elpep\\idea\\CryptAnalyzer\\src\\main\\resources\\demo_decrypted_by_bruteforce_text.txt";

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(demoToBruteForceTextFilePath));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(demoDecryptedByBruteFilePath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                DecryptionResult result = Caesar.decryptByBruteForce(line);
                String decryptedLine = result.getDecryptedText();
                int usedKey = result.getKey();
                bufferedWriter.write(decryptedLine);
                bufferedWriter.newLine();
                System.out.println("Использованный ключ: " + usedKey);
            }
            System.out.println("Брутфорс завершен. Результаты записаны в файл: " + demoDecryptedByBruteFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
