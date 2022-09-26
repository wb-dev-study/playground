package peter.baseball.domain;

import peter.baseball.exception.InvalidNumberException;

import java.util.Objects;

/**
 * Created by peter on 2022/09/19
 */
public class Ball {
    private int number;

    public Ball(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number >= 1 && number <= 9) {
            return;
        }
        throw new InvalidNumberException();
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
