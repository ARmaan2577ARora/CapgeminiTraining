package JSONDataFolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StudentJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode student = mapper.createObjectNode();
        student.put("name", "John Doe");
        student.put("age", 20);

        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Java");
        subjects.add("Spring Boot");
        subjects.add("Jackson");

        student.set("subjects", subjects);

        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println("Student JSON Object:");
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
