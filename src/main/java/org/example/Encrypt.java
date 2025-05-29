package org.example;

public class Encrypt {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\"’:-!? \n";


    public static String encrypt(String data, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : data.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                int shiftedIndex = (index + key) % ALPHABET.length();
                if (shiftedIndex < 0){
                    shiftedIndex+=ALPHABET.length();
                }
                result.append(ALPHABET.charAt(shiftedIndex));
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String data, int key){
        return encrypt(data,-key);
    }
}
