package peter.racingcar.domain;

import peter.racingcar.exception.NotEnoughEntryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by peter on 2022/09/24
 */
public class GameEntryInput {
    List<Car> entries;
    public GameEntryInput(String entryNames, Integer round) {
        validate(entryNames);
        List<String> splitEntries = Arrays.stream(entryNames.split(",")).map(String::trim).collect(Collectors.toList());
        entries = new ArrayList<>();
        for (String entry : splitEntries) {
            entries.add(new RacingCar(entry));
        }
    }

    public List<Car> getEntries() {
        return entries;
    }

    private void validate(String entryName) {
        if (entryName.split(",").length == 1) {
            throw new NotEnoughEntryException("참가자는 2명 이상이어야 합니다.");
        }
    }
}
