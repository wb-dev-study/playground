package hailey.racingcar.domain;

public class Score {
    private int score;
    private final StringBuilder progress;

    public int getScore() {
        return this.score;
    }

    public StringBuilder getProgress() {
        return this.progress;
    }

    public Score() {
        this.score = 0;
        this.progress = new StringBuilder();
    }

    public void setScore(int score) {
        this.score = score;
    }
}
