package peter.racingcar.exception;

/**
 * Created by peter on 2022/09/24
 * 참가자 이름이 너무 긴 경우 발생하는 예외
 */
public class EntryNameTooLongException extends RuntimeException {
    public EntryNameTooLongException(final String message) {
        super(message);
    }
}
