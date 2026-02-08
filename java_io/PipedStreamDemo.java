package java_io;

import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        Thread writerThread = new Thread(() -> {
            try {
                String msg = "Hello from the writer thread!";
                pos.write(msg.getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                int data;
                System.out.print("Reader receiving: ");
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                System.out.println();
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();
    }
}
