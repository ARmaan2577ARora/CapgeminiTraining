package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExtraction {
    public static void main(String[] args) {
        String jsonInput = "{\"id\": 1, \"name\": \"Alice Smith\", \"email\": \"alice@example.com\", \"details\": {\"city\": \"London\", \"zip\": \"12345\"}}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(jsonInput);

            String name = root.get("name").asText();
            String email = root.get("email").asText();

            System.out.println("Extracted Fields:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
