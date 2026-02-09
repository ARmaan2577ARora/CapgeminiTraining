package CSVDataHandling;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptedCSVHandling {
    private static final String KEY = "1234567812345678";
    private static final String ALGORITHM = "AES";

    public static String encrypt(String value) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedValue) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedValue);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }

    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/encrypted_employees.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            bw.write("ID,Name,Email(Encrypted)\n");
            bw.write("1,Alice," + encrypt("alice@example.com") + "\n");
            bw.write("2,Bob," + encrypt("bob@corp.com") + "\n");
            System.out.println("Encrypted data written to: " + csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nReading and Decrypting Data:");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String decryptedEmail = decrypt(data[2]);
                System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Email: " + decryptedEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
