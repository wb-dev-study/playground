package zoey.racingcar.domain;


import zoey.racingcar.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Drivers drivers;
    public static final int PIVOT_NUMBER = 4;

    public RacingGame(Drivers drivers) {
        this.drivers = drivers;
    }

    public List<Car> winner() {
        return drivers.getParticipants().stream()
                .filter(car -> car.getLocation() == drivers.maxLocation())
                .collect(Collectors.toList());
    }

    public Drivers race() {
        drivers.getParticipants().forEach(racer -> {
            if (isMovable()) racer.drive();
        });
        return drivers;
    }
    private boolean isMovable() {
        return NumberGenerator.getRandomNumber() >= PIVOT_NUMBER;
    }
}
