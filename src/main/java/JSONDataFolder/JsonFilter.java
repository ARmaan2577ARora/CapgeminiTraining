package JSONDataFolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class JsonFilter {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        String jsonInput = "[" +
                "{\"name\": \"Alice\", \"age\": 22}," +
                "{\"name\": \"Bob\", \"age\": 30}," +
                "{\"name\": \"Charlie\", \"age\": 28}," +
                "{\"name\": \"David\", \"age\": 24}" +
                "]";

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Person> people = mapper.readValue(jsonInput, new TypeReference<List<Person>>() {
            });

            List<Person> filtered = people.stream()
                    .filter(p -> p.getAge() > 25)
                    .collect(Collectors.toList());

            System.out.println("People older than 25:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filtered));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
