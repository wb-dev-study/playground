package zoey.racingcar.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    Drivers drivers;
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        drivers = new Drivers("zoey, dan");
        racingGame = new RacingGame(drivers);
    }

    @Test
    void race() {
        Drivers record = racingGame.race();

        assertThat(record).isNotNull();
    }

    @Test
    void winner() {
        racingGame.race();
        List<Car> winner = racingGame.winner();

        assertThat(winner.size()).isGreaterThan(0);
    }
}
