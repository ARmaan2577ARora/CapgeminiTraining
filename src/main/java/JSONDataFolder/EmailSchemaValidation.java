package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class EmailSchemaValidation {
    public static void main(String[] args) {
        String schemaStr = "{" +
                "\"$schema\": \"http://json-schema.org/draft-07/schema#\"," +
                "\"type\": \"object\"," +
                "\"properties\": {" +
                "  \"email\": {" +
                "    \"type\": \"string\"," +
                "    \"format\": \"email\"" +
                "  }" +
                "}," +
                "\"required\": [\"email\"]" +
                "}";

        String validJson = "{\"email\": \"test@example.com\"}";
        String invalidJson = "{\"email\": \"invalid-email\"}";

        validate(schemaStr, validJson);
        validate(schemaStr, invalidJson);
    }

    private static void validate(String schemaStr, String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaStr);

        try {
            JsonNode node = mapper.readTree(jsonStr);
            Set<ValidationMessage> errors = schema.validate(node);

            if (errors.isEmpty()) {
                System.out.println("Validation Success for: " + jsonStr);
            } else {
                System.out.println("Validation Failed for: " + jsonStr);
                errors.forEach(err -> System.out.println(" - " + err.getMessage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
