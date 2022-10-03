package peter.baseball.domain;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by peter on 2022/09/19
 */
public class Game {
    Set<Ball> balls = new LinkedHashSet<>();

    public Game() {
        Random random = new Random();
        while (balls.size() < 3) {
            balls.add(new Ball(random.nextInt(9) + 1));
        }
    }

    public Set<Ball> getBalls() {
        return balls;
    }

    public String getSuccessMessage() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String getRetryMessage() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
