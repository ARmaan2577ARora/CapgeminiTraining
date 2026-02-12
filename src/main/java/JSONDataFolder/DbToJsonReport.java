package JSONDataFolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;

public class DbToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:h2:mem:testdb";
        ObjectMapper mapper = new ObjectMapper();

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))");
            stmt.execute("INSERT INTO users VALUES (1, 'Alice', 'alice@test.com'), (2, 'Bob', 'bob@test.com')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            ArrayNode reportArray = mapper.createArrayNode();

            while (rs.next()) {
                ObjectNode userNode = mapper.createObjectNode();
                userNode.put("id", rs.getInt("id"));
                userNode.put("name", rs.getString("name"));
                userNode.put("email", rs.getString("email"));
                reportArray.add(userNode);
            }

            System.out.println("JSON Report from Database:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reportArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
