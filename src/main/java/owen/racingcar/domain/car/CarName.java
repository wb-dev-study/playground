package owen.racingcar.domain.car;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private final String carName;

    private static final int MAX_NAME = 5;

    public CarName(String carName) {
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
        }

        if (carName.length() > MAX_NAME) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
