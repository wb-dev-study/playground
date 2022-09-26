package peter.baseball.exception;

/**
 * Created by peter on 2022/09/19
 */
public class SizeNotMatchException extends RuntimeException {
    public SizeNotMatchException() {
        super("중복되지않은 3자리 숫자를 입력해주세요.");
    }
}
