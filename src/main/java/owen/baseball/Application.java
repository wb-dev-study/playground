package owen.baseball;


import owen.baseball.domain.ball.Balls;
import owen.baseball.domain.ball.BallFactory;
import owen.baseball.util.GameView;

public class Application {
    public static void main(String[] args) {
        Balls computerBalls = BallFactory.computerBall();
        GameView gameView = new GameView(computerBalls);
        gameView.start();
    }
}
