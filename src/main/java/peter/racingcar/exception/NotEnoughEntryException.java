package peter.racingcar.exception;

/**
 * Created by peter on 2022/09/25
 * 참가자가 충분하지 않을 때 발생하는 예외
 */
public class NotEnoughEntryException extends RuntimeException {
    public NotEnoughEntryException(final String message) {
        super(message);
    }
}
