package zoey.baseball.domain;

public class BallGameResult {
    private final int ball;
    private final int strike;

    public static int THREE_STRIKE = 3;

    public BallGameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isThreeStrike() {
        return this.strike == THREE_STRIKE;
    }

    public String getResult() {
        if (ball == 0 && strike == 0) {
            return "nothing!!";
        }
        if (ball == 0) {
            return String.format("%d 스트라이크", this.strike);
        }
        if (strike == 0) {
            return String.format("%d 볼", this.ball);
        }
        return String.format("%d 볼 %d 스트라이크", this.ball, this.strike);
    }
}
