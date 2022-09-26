package peter.baseball;

import org.junit.jupiter.api.Test;
import peter.baseball.domain.Ball;
import peter.baseball.domain.Game;
import peter.baseball.domain.GameResult;
import peter.baseball.domain.GameResultChecker;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by peter on 2022/09/19
 */
public class GameResultCheckerTest {
    @Test
    void gameResultTest() {
        Set<Ball> answer = new LinkedHashSet<>();
        Game game = new Game();
        answer.addAll(Set.of(new Ball(5), new Ball(1), new Ball(2)));

        GameResult result = new GameResultChecker().checkResult(game, answer);
        System.out.println(result.print());
    }
}
