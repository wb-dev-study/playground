package zoey.racingcar.domain;

public class Car {
    private final String name;
    private int location;

    private static final int START_POSITION = 1;
    private static final int MAX_NAME_LENGTH = 6;

    public Car(String name) {
        this.name = validateName(name);
        this.location = START_POSITION;
    }
    private String validateName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
        return trimmedName;
    }

    public String getNameAndPosition() {
        return String.format("%s : %s", this.name, visualizeCurrentLocation());
    }

    private String visualizeCurrentLocation() {
        return "-".repeat(this.location);
    }

    public void drive() {
        this.location++;
    }
}
