package owen.baseball.util;

import owen.baseball.domain.Result;
import owen.baseball.domain.ball.BallFactory;
import owen.baseball.domain.ball.Balls;

import java.util.Scanner;

public class GameView {

    private Balls computerBalls;

    public static final Scanner scanner = new Scanner(System.in);

    public GameView(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public void start() {
        boolean process = true;
        do{
            System.out.println("숫자를 입력해 주세요 : ");
            String userInput = scanner.nextLine();

            Balls userBalls = BallFactory.makeBall(userInput);
            Result playResult = userBalls.play(computerBalls);
            System.out.println(playResult.doPrint());

            process = checkEndGame(playResult.is3Strike());

        } while (process);
    }

    private boolean checkEndGame(boolean is3Strike) {
        if (!is3Strike) {
            return true;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            computerBalls = BallFactory.computerBall();
            return true;
        }

        if (userInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("숫자(1 or 2)만 입력가능합니다.");
    }
}
