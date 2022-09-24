package peter.racingcar.domain;

import peter.racingcar.exception.EntryNameTooLongException;

import java.util.Objects;
import java.util.Random;

/**
 * Created by peter on 2022/09/24
 */
public class RacingCar implements Car {
    private String name;
    private int distance = 0;
    private int RANDOM_MAX = 9;
    private int MOVE_MIN = 4;
    private int MOVE_MAX = 9;
    private int NAME_LIMIT = 5;
    private Random random;
    private String DISTANCE_CHARACTER = "-";

    public RacingCar(String name) {
        this.name = name;
        random = new Random(System.currentTimeMillis());
        validate();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getDistance() {
        return distance;
    }
    private void validate() {
        if (name.length() > NAME_LIMIT) {
            throw new EntryNameTooLongException("참가자의 이름은 " + NAME_LIMIT + "자 이하만 가능합니다.");
        }
    }

    @Override
    public void move() {
        int randomValue = random.nextInt(RANDOM_MAX);
        if (isMovable(randomValue)) {
            distance++;
        }
    }

    @Override
    public void showLocation() {
        String distanceRange = "";
        for (int start = 0; start < distance; start++) {
            distanceRange += DISTANCE_CHARACTER;
        }
        System.out.println(name + " : + " + distanceRange);
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MOVE_MIN && randomValue <= MOVE_MAX;
    }
}
