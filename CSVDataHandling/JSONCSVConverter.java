package CSVDataHandling;

import java.io.*;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonInput = "[{\"id\":101,\"name\":\"John\",\"age\":20},{\"id\":102,\"name\":\"Jane\",\"age\":22}]";
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students_from_json.csv";

        jsonToCsv(jsonInput, csvFile);

        String jsonOutput = csvToJson(csvFile);
        System.out.println("Converted JSON back from CSV:");
        System.out.println(jsonOutput);
    }

    public static void jsonToCsv(String json, String csvPath) {
        try (FileWriter fw = new FileWriter(csvPath)) {
            fw.write("id,name,age\n");
            String content = json.substring(2, json.length() - 2);
            String[] objects = content.split("\\},\\{");
            for (String obj : objects) {
                String[] pairs = obj.split(",");
                StringBuilder row = new StringBuilder();
                for (String pair : pairs) {
                    row.append(pair.split(":")[1].replace("\"", "")).append(",");
                }
                fw.write(row.substring(0, row.length() - 1) + "\n");
            }
            System.out.println("JSON converted to CSV at: " + csvPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String csvToJson(String csvPath) {
        StringBuilder json = new StringBuilder("[");
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String[] headers = br.readLine().split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                json.append("{");
                for (int i = 0; i < headers.length; i++) {
                    json.append("\"").append(headers[i]).append("\":");
                    try {
                        Integer.parseInt(values[i]);
                        json.append(values[i]);
                    } catch (NumberFormatException e) {
                        json.append("\"").append(values[i]).append("\"");
                    }
                    if (i < headers.length - 1)
                        json.append(",");
                }
                json.append("},");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (json.length() > 1)
            json.setLength(json.length() - 1);
        json.append("]");
        return json.toString();
    }
}
