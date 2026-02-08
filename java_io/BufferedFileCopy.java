package java_io;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourcePath = "large_file.txt";
        String bufferedDestPath = "buffered_dest.txt";
        String normalDestPath = "normal_dest.txt";
        createDummyLargeFile(sourcePath, 1);

        System.out.println("Performance Comparison (1 MB file):");

        long startTime = System.nanoTime();
        copyUnbuffered(sourcePath, normalDestPath);
        long endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        
        startTime = System.nanoTime();
        copyBuffered(sourcePath, bufferedDestPath);
        endTime = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    private static void copyUnbuffered(String src, String dest) {
        try (FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dest)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyBuffered(String src, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDummyLargeFile(String path, int sizeInMB) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
            byte[] data = "Dummy content for large file copy performance testing. ".getBytes();
            for (int i = 0; i < (sizeInMB * 1024 * 1024) / data.length; i++) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
