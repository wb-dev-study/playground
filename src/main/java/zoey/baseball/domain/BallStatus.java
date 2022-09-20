package zoey.baseball.domain;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this.equals(BALL);
    }

    public boolean isStrike() {
        return this.equals(STRIKE);
    }
}
