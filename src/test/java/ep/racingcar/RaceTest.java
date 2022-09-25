package ep.racingcar;

import ep.racingcar.domain.Car;
import ep.racingcar.domain.Participants;
import ep.racingcar.domain.Race;
import ep.racingcar.domain.strategy.DefaultMovingStrategy;
import ep.racingcar.domain.strategy.MovingStrategy;
import ep.racingcar.domain.strategy.RandomMovingStrategy;
import ep.racingcar.exception.RaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    private Participants participants;
    private Car epCar;
    private Car jakeCar;

    @BeforeEach
    void setUp() {
        this.epCar = new Car("ep");
        this.jakeCar = new Car("jake");
        List<Car> carList = List.of(epCar, jakeCar);
        this.participants = new Participants(carList);
    }

    @Test
    @DisplayName("매 라운드를 진행시키면 차는 무빙 전략을 실행한다")
    void race_round() {
        Race race = new Race(participants, 2, new DefaultMovingStrategy());
        race.nextRound();
        race.nextRound();
        assertThat(epCar.currentPosition()).isEqualTo(2);
        assertThat(jakeCar.currentPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("모든 라운드를 진행시키면 레이스가 종료된다.")
    void race_end() {
        Race race = new Race(participants, 2, new DefaultMovingStrategy());
        race.nextRound();
        race.nextRound();
        assertThat(race.isEnd()).isTrue();
    }

    @Test
    @DisplayName("경기가 멈췄는데 라운드를 진행하면 에러가 발생한다")
    void race_end_next_round() {
        Race race = new Race(participants, 2, new DefaultMovingStrategy());
        race.nextRound();
        race.nextRound();
        assertThat(race.isEnd()).isTrue();
        assertThatThrownBy(
                () -> race.nextRound()
        ).isInstanceOf(RaceException.class);
    }

    @Test
    @DisplayName("가장 먼저 도착해 우승한 멤버를 가져온다.")
    void race_winner() {
        Race race = new Race(participants, 2);
        race.changeMovingStrategy(car -> {
            if (car.isEqualName("ep")) {
                car.move();
            }
        });
        race.nextRound();
        race.nextRound();
        List<Car> winners = race.winners();
        assertThat(winners).containsOnly(epCar);
    }

    @Test
    @DisplayName("우승한 멤버는 여럿일 수 있다.")
    void race_winners() {
        Race race = new Race(participants, 2);
        race.nextRound();
        race.nextRound();
        List<Car> winners = race.winners();
        assertThat(winners).containsOnly(epCar, jakeCar);
    }
}
