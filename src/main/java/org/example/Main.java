package org.example;

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
                case "1" -> System.out.println("Метод 1");
                case "2" -> System.out.println("Метод 2");
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
}