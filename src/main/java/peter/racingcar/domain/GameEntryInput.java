package peter.racingcar.domain;

import peter.racingcar.exception.InvalidRoundException;
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
    Integer round;
    public GameEntryInput(String entryNames, String round) {
        validate(entryNames, round);
        List<String> splitEntries = Arrays.stream(entryNames.split(",")).map(String::trim).collect(Collectors.toList());
        entries = new ArrayList<>();
        for (String entry : splitEntries) {
            entries.add(new RacingCar(entry));
        }
    }

    public List<Car> getEntries() {
        return entries;
    }

    public Integer getRound() {
        return round;
    }

    private void validate(String entryName, String round) {
        if (entryName.split(",").length == 1) {
            throw new NotEnoughEntryException("참가자는 2명 이상이어야 합니다.");
        }
        try {
            this.round = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new InvalidRoundException("횟수는 숫자만 입력 가능합니다.");
        }
    }
}
