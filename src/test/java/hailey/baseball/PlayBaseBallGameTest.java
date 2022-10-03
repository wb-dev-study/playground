package hailey.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayBaseBallGameTest {

    PlayBaseBallGame playBaseBallGame = new PlayBaseBallGame();
    private List<Ball> answerBalls;

    @BeforeEach
    void setUp() {
        answerBalls = Ball.makeBall(Arrays.asList(8, 5, 9));
    }

    @Test
    @DisplayName("스트라이크 판별")
    void check_3strike() {
        List<Ball> userBalls = Ball.makeBall(Arrays.asList(8, 5, 9));
        PlayResult playResult = playBaseBallGame.matchAnswer(answerBalls, userBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("볼 판별")
    void check_ball() {
        List<Ball> userBalls = Ball.makeBall(Arrays.asList(5, 3, 4));
        PlayResult playResult = playBaseBallGame.matchAnswer(answerBalls, userBalls);
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("nothing 판별")
    void check_noting() {
        List<Ball> userBalls = Ball.makeBall(Arrays.asList(1, 7, 6));
        PlayResult playResult = playBaseBallGame.matchAnswer(answerBalls, userBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }
}
