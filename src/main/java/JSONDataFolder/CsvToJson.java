package JSONDataFolder;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.List;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) {
        String csvData = "id,name,city\n1,Alice,London\n2,Bob,Paris\n3,Charlie,Berlin";

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            MappingIterator<Map<?, ?>> it = csvMapper.readerFor(Map.class).with(schema).readValues(csvData);
            List<Map<?, ?>> list = it.readAll();

            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println("CSV converted to JSON:");
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
