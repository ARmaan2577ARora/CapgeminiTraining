package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileSync {
    public static void main(String[] args) {
        String file1Path = "file1.json";
        String file2Path = "file2.json";

        ObjectMapper mapper = new ObjectMapper();

        try {
            if (!new File(file1Path).exists()) {
                Files.writeString(Paths.get(file1Path), "{\"id\": 101, \"status\": \"active\"}");
            }
            if (!new File(file2Path).exists()) {
                Files.writeString(Paths.get(file2Path), "{\"metadata\": {\"lastLogin\": \"2023-10-01\"}}");
            }

            JsonNode node1 = mapper.readTree(new File(file1Path));
            JsonNode node2 = mapper.readTree(new File(file2Path));

            ((ObjectNode) node1).setAll((ObjectNode) node2);

            System.out.println("Merged JSON from Files:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node1));

            new File(file1Path).delete();
            new File(file2Path).delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
