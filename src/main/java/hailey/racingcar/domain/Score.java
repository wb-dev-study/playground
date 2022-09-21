package hailey.racingcar.domain;

public class Score {
    private int score;
    private StringBuilder progress;

    public Score() {
        this.score = 0;
        this.progress = new StringBuilder();
    }
}
