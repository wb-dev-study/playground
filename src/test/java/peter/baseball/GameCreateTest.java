package peter.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import peter.baseball.domain.Game;

/**
 * Created by peter on 2022/09/19
 */
public class GameCreateTest {
    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        Game game = new Game();
        System.out.println(game.getBalls());
        Assertions.assertThat(game.getBalls().size()).isEqualTo(3);
    }
}
