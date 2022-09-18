package owen.baseball;


import owen.baseball.domain.ball.Balls;
import owen.baseball.util.BallFactory;
import owen.baseball.util.Result;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean process = true;
        Balls computerBalls = BallFactory.computerBall();
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("숫자를 입력해 주세요 : ");
            String userInput = scanner.nextLine();

            Balls userBalls = BallFactory.makeBall(userInput);
            Result playResult = computerBalls.play(userBalls);
            System.out.println(playResult.doPrint());

            if (playResult.is3Strike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                process = scanner.nextLine().equals("1");
                computerBalls = BallFactory.computerBall();
            }

        } while (process);
    }
}
