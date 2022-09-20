package hailey.baseball;

public class BallNumber {
    private int no;

    public BallNumber(int no) {
        this.no = ValidationUtils.validateNumber(no);
    }

    public int getNo() {
        return this.no;
    }
}
