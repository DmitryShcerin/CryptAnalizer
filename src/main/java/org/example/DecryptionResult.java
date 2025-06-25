package org.example;

public class DecryptionResult {
    private String decryptedText;
    private int key;

    public DecryptionResult(String decryptedText, int key) {
        this.decryptedText = decryptedText;
        this.key = key;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public int getKey() {
        return key;
    }
}
