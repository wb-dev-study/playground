package owen.baseball.domain.ball;

import owen.baseball.domain.BallStatus;
import owen.baseball.util.Result;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answerBalls;

    public Balls(List<Integer> answerBall) {
        this.answerBalls = createBalls(answerBall);
    }

    public Result play(Balls userBalls) {
        Result result = new Result();

        for (Ball ball : answerBalls) {
            result.checkResult(userBalls.playBall(ball));
        }
        return result;
    }

    public BallStatus playBall(Ball userBalls) {
        return answerBalls.stream().map(answerBall -> answerBall.playBall(userBalls))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public List<Ball> createBalls(List<Integer> answerBall) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answerBall.size(); i++) {
            balls.add(new Ball(answerBall.get(i), i + 1));
        }
        return balls;
    }
}
