package java_io;

import java.io.*;

public class LargeFileErrorFinder {
    public static void main(String[] args) {
        String logPath = "system.log";

        createDummyLogFile(logPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(logPath))) {
            String line;
            System.out.println("Filtering log file for errors:");
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDummyLogFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("INFO: System started\n");
            writer.write("DEBUG: Initializing modules\n");
            writer.write("ERROR: Database connection failed\n");
            writer.write("INFO: Retrying connection...\n");
            writer.write("error: invalid credentials detected\n");
            writer.write("WARN: Memory usage high\n");
            writer.write("INFO: Operation successful\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
