package hailey.racingcar;

import hailey.racingcar.domain.Car;
import hailey.racingcar.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    PlayGame playGame = new PlayGame();

    private Map<Car, Score> cars;


    @BeforeEach
    void setUp() {
        cars = new LinkedHashMap<>();
        Score score = new Score();
        score.advance(7);
        cars.put(new Car("car1"), score);
        cars.put(new Car("car2"), new Score());
        cars.put(new Car("car3"), new Score());
    }

    @Test
    @DisplayName("우승자 찾기")
    void find_winners() {
        Map<Car, Score> winners = playGame.findWinners(cars);
        assertThat(winners.size()).isEqualTo(1);
        Iterator<Car> winner = winners.keySet().iterator();
        assertThat(winner.next().getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("게임 한 번 반복")
    void turn_around() {
        playGame.turnAround(cars);
    }

    @Test
    @DisplayName("게임 종료")
    void end_game() {
        Map<Car, Score> winners = playGame.findWinners(cars);
        playGame.endGame(winners);
    }
}
