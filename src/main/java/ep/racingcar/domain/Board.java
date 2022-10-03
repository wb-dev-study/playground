package ep.racingcar.domain;

import java.util.List;

public class Board {

    private List<CurrentCarData> currentCarData;

    public Board(List<CurrentCarData> currentCarData) {
        this.currentCarData = currentCarData;
    }

    public List<CurrentCarData> getCurrentCarData() {
        return currentCarData;
    }

    public static class CurrentCarData {
        private String carName;
        private Integer position;

        public CurrentCarData(String carName, Integer position) {
            this.carName = carName;
            this.position = position;
        }

        public String getCarName() {
            return carName;
        }

        public Integer getPosition() {
            return position;
        }
    }
}
