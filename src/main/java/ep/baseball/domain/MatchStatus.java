package ep.baseball.domain;

public enum MatchStatus {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    public String kr() {
        return kr;
    }

    private String kr;
    MatchStatus(String kr) {
        this.kr = kr;
    }
}
