import java.io.*;
import java.util.Random;

public class OTP {
    private String plainText;
    private String cipherText;
    public String key;

    OTP(String plainText) {
        this.plainText = plainText;
    }

    private void generateKey() {
        StringBuilder ans = new StringBuilder();
        Random random = new Random();
        int length = plainText.length();

        for (int i = 0; i < length; i++) {
            int j = ('a' + random.nextInt(26));
            // System.out.println(j);
            char randomChar = (char) (j);
            ans.append(randomChar);
        }

        this.key = ans.toString();
        System.out.println("Generated key: " + key);
    }

    private void encrypt() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int cipher = (this.plainText.charAt(i) - 'a' + this.key.charAt(i) - 'a');
            if (cipher > 25) {
                cipher = cipher - 26;
            }
            char encryptedChar = (char) (cipher + 'a');
            ans.append(encryptedChar);
            // int asciiValue = plainText.charAt(i) + key.charAt(i);
            // System.err.println(asciiValue);
        }

        this.cipherText = ans.toString();
        System.out.println("Ciphertext: " + cipherText);
    }

    private String decrypt() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int plain = (this.cipherText.charAt(i) - 'a' - this.key.charAt(i) + 'a');
            if (plain < 0) {
                plain = plain + 26;
            }
            char decryptedChar = (char) (plain + 'a');
            ans.append(decryptedChar);
            // int asciiValue = plainText.charAt(i) + key.charAt(i);
            // System.err.println(asciiValue);
        }

        String decryptedString = ans.toString();
        return decryptedString;
    }

    public static void main(String[] args) {
        OTP sol = new OTP("vernamcipher");
        sol.generateKey();
        sol.encrypt();
        System.out.println("Decrypted text: " + sol.decrypt());
    }
}
