package JSONDataFolder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CarToJson {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Car {
        private String brand;
        private String model;
        private int year;
        private String color;
    }

    public static void main(String[] args) {
        Car car = new Car("Tesla", "Model 3", 2023, "Red");
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            System.out.println("Car Object converted to JSON:");
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
