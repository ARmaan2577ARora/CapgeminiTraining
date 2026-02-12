package JSONDataFolder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @JsonProperty("match_id")
    private int matchId;

    private String team1;
    private String team2;

    private Map<String, Integer> score;

    private String winner;

    @JsonProperty("player_of_match")
    private String playerOfMatch;

    public void applyCensorship() {
        this.team1 = censorTeam(this.team1);
        this.team2 = censorTeam(this.team2);
        this.winner = censorTeam(this.winner);
        this.playerOfMatch = "REDACTED";

        if (score != null) {
            java.util.Map<String, Integer> newScore = new java.util.HashMap<>();
            for (Map.Entry<String, Integer> entry : score.entrySet()) {
                newScore.put(censorTeam(entry.getKey()), entry.getValue());
            }
            this.score = newScore;
        }
    }

    private String censorTeam(String name) {
        if (name == null || !name.contains(" "))
            return name;
        int firstSpace = name.indexOf(" ");
        return name.substring(0, firstSpace) + " ***";
    }
}
