package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMerge {
    public static void main(String[] args) {
        String json1 = "{\"name\": \"John\", \"age\": 30}";
        String json2 = "{\"city\": \"New York\", \"job\": \"Engineer\"}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node1 = mapper.readTree(json1);
            JsonNode node2 = mapper.readTree(json2);

            ((ObjectNode) node1).setAll((ObjectNode) node2);

            System.out.println("Merged JSON:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
