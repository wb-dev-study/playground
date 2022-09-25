package ep.racingcar;

import ep.racingcar.domain.Car;
import ep.racingcar.domain.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void setUp() {
        Car epCar = new Car("ep");
        Car jakeCar = new Car("jake");
        List<Car> carList = List.of(epCar, jakeCar);
        participants = new Participants(carList);
    }

    @Test
    @DisplayName("참여를 추가적으로 할 수 있다.")
    void participants_participate() {
        Car kimCar = new Car("kim");
        participants.participate(kimCar);
        assertThat(participants.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("참여자는 자동차 리스트를 가지고 있다")
    void participants_count() {
        assertThat(participants.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("참여자는 본인이 참가자인지 확인할 수 있다")
    void participants_has_participant() {
        Car epCar = new Car("ep");
        assertThat(participants.isParticipant(epCar)).isTrue();
    }
}
