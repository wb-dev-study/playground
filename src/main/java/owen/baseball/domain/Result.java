package owen.baseball.domain;


public class Result {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void checkResult(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
        }

        if (ballStatus.isBall()) {
            ball++;
        }
    }

    public String doPrint() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball == 0) {
            return String.format("%d 스트라이크", strike);
        }

        if (strike == 0) {
            return String.format("%d 볼", ball);
        }
        return String.format("%d 볼 %d 스트라이크", ball, strike);
    }

    public boolean is3Strike() {
        return strike == 3;
    }
}
