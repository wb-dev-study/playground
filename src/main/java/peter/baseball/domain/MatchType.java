package peter.baseball.domain;

/**
 * Created by peter on 2022/09/19
 */
public enum MatchType {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");
    private String message;
    MatchType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
