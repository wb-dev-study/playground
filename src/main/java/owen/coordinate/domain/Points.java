package owen.coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Coordinates> coordinates;

    public Points(List<List<Integer>> userInputNumbers) {
        this.coordinates = new ArrayList<>();
        for (List<Integer> userInputNumber : userInputNumbers) {
            coordinates.add(new Coordinates(userInputNumber));
        }
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
}
