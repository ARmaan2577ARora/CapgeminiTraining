package JSONDataFolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLCensorAnalyzer {

    private static final ObjectMapper jsonMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final CsvMapper csvMapper = new CsvMapper();

    public static void main(String[] args) {
        String inputJsonPath = "ipl_data_input.json";
        String inputCsvPath = "ipl_data_input.csv";

        createSampleFiles(inputJsonPath, inputCsvPath);

        try {
            List<Match> jsonMatches = readJson(inputJsonPath);
            jsonMatches.forEach(Match::applyCensorship);
            writeJson(jsonMatches, "ipl_data_censored.json");
            System.out.println("Censored JSON created: ipl_data_censored.json");

            List<Match> csvMatches = readCsv(inputCsvPath);
            csvMatches.forEach(Match::applyCensorship);
            writeCsv(csvMatches, "ipl_data_censored.csv");
            System.out.println("Censored CSV created: ipl_data_censored.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Match> readJson(String path) throws IOException {
        return jsonMapper.readValue(new File(path), new TypeReference<List<Match>>() {
        });
    }

    public static void writeJson(List<Match> matches, String path) throws IOException {
        jsonMapper.writeValue(new File(path), matches);
    }

    public static List<Match> readCsv(String path) throws IOException {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class).with(schema)
                .readValues(new File(path));
        List<Map<String, String>> rows = it.readAll();

        List<Match> matches = new ArrayList<>();
        for (Map<String, String> row : rows) {
            Match m = new Match();
            m.setMatchId(Integer.parseInt(row.get("match_id")));
            m.setTeam1(row.get("team1"));
            m.setTeam2(row.get("team2"));
            m.setWinner(row.get("winner"));
            m.setPlayerOfMatch(row.get("player_of_match"));

            Map<String, Integer> score = new HashMap<>();
            score.put(m.getTeam1(), Integer.parseInt(row.get("score_team1")));
            score.put(m.getTeam2(), Integer.parseInt(row.get("score_team2")));
            m.setScore(score);

            matches.add(m);
        }
        return matches;
    }

    public static void writeCsv(List<Match> matches, String path) throws IOException {
        List<Map<String, Object>> flatRows = new ArrayList<>();
        for (Match m : matches) {
            Map<String, Object> row = new HashMap<>();
            row.put("match_id", m.getMatchId());
            row.put("team1", m.getTeam1());
            row.put("team2", m.getTeam2());
            row.put("winner", m.getWinner());
            row.put("player_of_match", m.getPlayerOfMatch());

            row.put("score_team1", m.getScore().get(m.getTeam1()));
            row.put("score_team2", m.getScore().get(m.getTeam2()));

            flatRows.add(row);
        }

        CsvSchema schema = CsvSchema.builder()
                .addColumn("match_id")
                .addColumn("team1")
                .addColumn("team2")
                .addColumn("score_team1")
                .addColumn("score_team2")
                .addColumn("winner")
                .addColumn("player_of_match")
                .build().withHeader();

        csvMapper.writer(schema).writeValue(new File(path), flatRows);
    }

    private static void createSampleFiles(String jsonPath, String csvPath) {
        String jsonContent = "[\n" +
                "  {\n" +
                "    \"match_id\": 101,\n" +
                "    \"team1\": \"Mumbai Indians\",\n" +
                "    \"team2\": \"Chennai Super Kings\",\n" +
                "    \"score\": {\n" +
                "      \"Mumbai Indians\": 178,\n" +
                "      \"Chennai Super Kings\": 182\n" +
                "    },\n" +
                "    \"winner\": \"Chennai Super Kings\",\n" +
                "    \"player_of_match\": \"MS Dhoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"match_id\": 102,\n" +
                "    \"team1\": \"Royal Challengers Bangalore\",\n" +
                "    \"team2\": \"Delhi Capitals\",\n" +
                "    \"score\": {\n" +
                "      \"Royal Challengers Bangalore\": 200,\n" +
                "      \"Delhi Capitals\": 190\n" +
                "    },\n" +
                "    \"winner\": \"Royal Challengers Bangalore\",\n" +
                "    \"player_of_match\": \"Virat Kohli\"\n" +
                "  }\n" +
                "]";

        String csvContent = "match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n" +
                "101,Mumbai Indians,Chennai Super Kings,178,182,Chennai Super Kings,MS Dhoni\n" +
                "102,Royal Challengers Bangalore,Delhi Capitals,200,190,Royal Challengers Bangalore,Virat Kohli";

        try {
            java.nio.file.Files.writeString(java.nio.file.Paths.get(jsonPath), jsonContent);
            java.nio.file.Files.writeString(java.nio.file.Paths.get(csvPath), csvContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
