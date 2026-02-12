package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class JsonIteration {
    public static void main(String[] args) {
        String jsonInput = "{\"name\": \"Charlie\", \"age\": 28, \"city\": \"Berlin\", \"isStudent\": false}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(jsonInput);

            System.out.println("Iterating over JSON keys and values:");
            Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println(field.getKey() + " : " + field.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
