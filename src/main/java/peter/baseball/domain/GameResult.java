package peter.baseball.domain;

import java.util.Map;

/**
 * Created by peter on 2022/09/19
 */
public class GameResult {
    private Map<MatchType, Integer> result;

    public GameResult(Map<MatchType, Integer> result) {
        this.result = result;
    }

    public String print() {
        String message = "";
        for (MatchType matchType : MatchType.values()) {
            Integer count = result.get(matchType);
            if (count != null) {
                message += count + matchType.getMessage() + " ";
            }
        }
        return message;
    }

    public boolean is3Strike() {
        return result.getOrDefault(MatchType.STRIKE, 0) == 3;
    }
}
