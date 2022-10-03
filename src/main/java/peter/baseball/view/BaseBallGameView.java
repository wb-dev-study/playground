package peter.baseball.view;

import peter.baseball.domain.Ball;
import peter.baseball.domain.BallFactory;
import peter.baseball.domain.Game;
import peter.baseball.domain.GameResult;
import peter.baseball.domain.GameResultChecker;
import peter.baseball.exception.InvalidNumberException;
import peter.baseball.exception.SizeNotMatchException;

import java.util.Scanner;
import java.util.Set;


/**
 * Created by peter on 2022/09/19
 */
public class BaseBallGameView {
    public static void main(String[] args) {
        boolean playAnotherGame = true;
        Game game = new Game();
        GameResultChecker resultChecker = new GameResultChecker();
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("숫자를 입력해 주세요 : ");
                String input = scanner.nextLine();
                Set<Ball> answer = BallFactory.makeBalls(input);
                GameResult gameResult = resultChecker.checkResult(game, answer);
                System.out.println(gameResult.print());

                if (gameResult.is3Strike()) {
                    System.out.println(game.getSuccessMessage());
                    System.out.println(game.getRetryMessage());
                    playAnotherGame = scanner.nextLine().equals("1");
                    game = new Game();
                }

            } catch (InvalidNumberException | SizeNotMatchException e) {
                System.out.println(e.getMessage());
            }

        } while (playAnotherGame);
    }
}
