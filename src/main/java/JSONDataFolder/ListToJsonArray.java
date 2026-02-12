package JSONDataFolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User {
        private String username;
        private int id;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("user1", 101),
                new User("user2", 102),
                new User("user3", 103));

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
            System.out.println("List of Users as JSON Array:");
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
