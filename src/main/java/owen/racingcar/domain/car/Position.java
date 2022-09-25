package owen.racingcar.domain.car;

public class Position {

    private int position;

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public Position() {
        this.position = 0;
    }
}
