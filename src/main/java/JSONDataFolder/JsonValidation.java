package JSONDataFolder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidation {
    public static void main(String[] args) {
        String validJson = "{\"name\": \"Bob\", \"age\": 25}";
        String invalidJson = "{\"name\": \"Bob\", \"age\": 25";

        validate(validJson);
        validate(invalidJson);
    }

    private static void validate(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(json);
            System.out.println("Valid JSON: " + json);
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + json + " (Error: " + e.getMessage() + ")");
        }
    }
}
