package zoey.racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class DriversTest {

    @Test
    void createDrivers() {
        Drivers drivers = new Drivers("zoey, margo, dan, sidney");

        assertThat(drivers.getParticipants().size()).isEqualTo(4);
    }
}
