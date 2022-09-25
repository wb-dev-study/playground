package zoey.racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Drivers {
    private final List<Car> participants = new ArrayList<>();

    public Drivers(String names) {
        List<String> listOfName = Arrays.stream(names.split(",")).collect(Collectors.toList());
        listOfName.forEach(name -> participants.add(new Car(name)));
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    public void printDriversStatus() {
        this.participants.forEach(participant -> System.out.printf("%s%n", participant.getNameAndPosition()));
    }

    public int maxLocation() {
        Optional<Car> carOptional = this.participants.stream().max(Comparator.comparingInt(Car::getLocation));
        if (carOptional.isEmpty()) {
            throw new RuntimeException("empty car optional");
        }
        return carOptional.get().getLocation();
    }
}