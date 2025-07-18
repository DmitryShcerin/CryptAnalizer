package org.example;

public class Caesar {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\"’:-!? \n()[]";


    public static String encrypt(String data, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : data.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                int shiftedIndex = (index + key) % ALPHABET.length();
                if (shiftedIndex < 0) {
                    shiftedIndex += ALPHABET.length();
                }
                result.append(ALPHABET.charAt(shiftedIndex));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String data, int key) {
        return encrypt(data, -key);
    }

    public static int getAlphabetLength() {
        return ALPHABET.length();
    }

    public static DecryptionResult decryptByBruteForce(String encryptedText) {
        String[] Most_Frequent = {
                " и ", " в ", " с ", " у ", " я ", " а ", " о ", " на ",
                " не ", " но ", " по ", " за ", " из ", " от ", " до ", " к ",
                " со ", " то ", " бы ", " же ", " ли ", " ну ", " ибо ",
                " или ", " для ", " над ", " под ", " без ", " раз ",
                " он ", " она ", " оно ", " мы ", " вы ", " они ",
                " это ", " вот ", " даже ", " уж "
        };

        int maxMatches = -1;
        String bestDecryptedText = null;
        int bestKey = -1;

        for (int key = 1; key < getAlphabetLength(); key++) {
            String candidate = decrypt(encryptedText, key);
            int count = countFrequentWords(candidate, Most_Frequent);
            if (count > maxMatches) {
                maxMatches = count;
                bestDecryptedText = candidate;
                bestKey = key;
            }
        }
        return new DecryptionResult(bestDecryptedText, bestKey);
    }

    private static int countFrequentWords(String text, String[] words) {
        int count = 0;
        for (String word : words) {
            int index = 0;
            while ((index = text.indexOf(word, index)) != -1) {
                count++;
                index += word.length();
            }
        }
        return count;
    }
}
