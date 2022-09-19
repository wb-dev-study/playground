package baseball;

public class BallNumber {
    public int no;

    public BallNumber(int no) {
        this.no = ValidationUtils.validateNumber(no);
    }
}
