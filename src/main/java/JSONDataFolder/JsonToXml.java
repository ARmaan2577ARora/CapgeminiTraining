package JSONDataFolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) {
        String json = "{\"student\": {\"id\": 101, \"name\": \"John Doe\", \"grade\": \"A\"}}";

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        try {
            JsonNode node = jsonMapper.readTree(json);
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);

            System.out.println("JSON converted to XML:");
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
