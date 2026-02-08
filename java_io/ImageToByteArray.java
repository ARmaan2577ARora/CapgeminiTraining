package java_io;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "sample_image.jpg";
        String destImage = "output_image.jpg";

        createDummyBinaryFile(sourceImage);

        try {
            byte[] imageBytes = readImageToByteArray(sourceImage);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            writeByteArrayToImage(imageBytes, destImage);
            System.out.println("Byte array written back to: " + destImage);

            if (new File(sourceImage).length() == new File(destImage).length()) {
                System.out.println("Verification successful: File sizes match.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readImageToByteArray(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] data, String path) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
                FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        }
    }

    private static void createDummyBinaryFile(String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] dummyData = new byte[100];
            new Random().nextBytes(dummyData);
            fos.write(dummyData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Random {
    private long state = System.currentTimeMillis();

    public void nextBytes(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            state ^= (state << 13);
            state ^= (state >> 17);
            state ^= (state << 5);
            data[i] = (byte) state;
        }
    }
}
