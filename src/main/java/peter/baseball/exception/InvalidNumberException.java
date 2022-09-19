package peter.baseball.exception;

/**
 * Created by peter on 2022/09/19
 */
public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException() {
        super("숫자는 1부터 9까지만 입력가능합니다.");
    }
}
