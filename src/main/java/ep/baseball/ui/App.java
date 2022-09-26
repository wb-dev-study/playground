package ep.baseball.ui;

import ep.baseball.domain.ball.BallFactory;
import ep.baseball.domain.ball.Balls;

public class App {
    public static void main(String[] args) {
        Balls answer = BallFactory.answer();
        BaseballGameView baseballGameView = new BaseballGameView(answer);
        baseballGameView.start();
    }
}
