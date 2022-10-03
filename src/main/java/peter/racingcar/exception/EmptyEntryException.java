package peter.racingcar.exception;

/**
 * Created by peter on 2022/09/24
 * 참가 차량이 없는 경우에 발생한다.
 */
public class EmptyEntryException extends RuntimeException {
    public EmptyEntryException(final String message) {
        super(message);
    }
}
