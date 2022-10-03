package peter.racingcar.exception;

/**
 * Created by peter on 2022/09/24
 * 게임의 Round 가 지정된 값을 벗어났을 경우 발생한다.
 */
public class InvalidRoundException extends RuntimeException {
    public InvalidRoundException(final String message) {
        super(message);
    }
}
