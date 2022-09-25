package jay.racingcar.domain;

public class Car {
    private static final int MAX_LENGTH = 5;
    private static final int INIT_POSITION = 0;

    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public Car(String carName) {
        validateName(carName);
        this.name = carName;
        this.position = INIT_POSITION;
    }

    private void validateName(String carName) {
        String replace = carName.replaceAll(" ", "");

        if (replace.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력가능합니다.");
        }
    }
}
