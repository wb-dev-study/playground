package owen.racingcar.domain.car;

public class Car {

    private final CarName carName;

    private final Position position;

    private static final int MOVE_CONDITION = 4;

    public void move(int random) {
        if (random >= MOVE_CONDITION) {
            this.position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return carName.getCarName();
    }

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }
}
