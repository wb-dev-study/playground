package zoey.racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
