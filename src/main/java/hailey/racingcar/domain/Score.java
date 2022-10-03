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

    public void advance(int advanceNumber) {
        this.score = this.getScore() + advanceNumber;
        this.progress.append("-".repeat(advanceNumber));
    }

    public boolean isOnlyMaxScore(int max) {
        return this.getScore() > max;
    }

    public boolean isSameMaxScore(int max) {
        return this.getScore() == max;
    }
}
