package jay.baseball;

import java.util.List;

public class BaseballBatsman {
    public int total(List<Integer> computer, List<Integer> player) {
        int total = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                total += 1;
            }
        }
        return total;
    }


    public int strike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public int ball(int total, int strike) {
        return total - strike;
    }

    public String baseballResult(int total, int strike, int ball) {
        String result = "";

        if (total == 0) {
            return result = "낫싱";
        }

        if (strike == 0) {
            return result = ball + "볼";
        }

        if (ball == 0) {
            return result = strike + "스트라이크";
        }

        return result = ball + "볼 " + strike + "스트라이크";
    }
}
