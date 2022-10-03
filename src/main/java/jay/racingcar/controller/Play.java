package jay.racingcar.controller;

import jay.racingcar.Input;
import jay.racingcar.domain.Cars;
import jay.racingcar.domain.GameRound;
import jay.racingcar.factory.Winner;
import jay.racingcar.utils.StringUtils;

import java.util.Arrays;

public class Play {
    public static void main(String[] args) {
        Input input = new Input();

        Cars cars = new Cars(Arrays.asList(StringUtils.splitInputName(input.inputCarNames())));
        GameRound gameRound = new GameRound(input.inputRound());

        start(gameRound.getRound(), cars);
    }

    private static void start(int round, Cars cars) {
        for (int i = 0; i < round; i++) {
            cars.move();
        }

        Winner.findWinners(cars.getRacingCars());
    }
}
