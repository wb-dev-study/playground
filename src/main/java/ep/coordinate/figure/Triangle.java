package ep.coordinate.figure;

public class Triangle implements Figure {

    private final static String TRIANGLE_NAME = "삼각형";

    private Double a;
    private Double b;
    private Double c;

    public Triangle(Double a, Double b, Double c) {
        validate(a);
        validate(b);
        validate(c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void validate(Double argument) {
        if (argument == null) {
            throw new IllegalArgumentException("변은 null 일 수 없습니다.");
        }
        if (argument <= 0) {
            throw new IllegalArgumentException("변의 길이는 0보다 커야 합니다.");
        }
    }

    @Override
    public String name() {
        return TRIANGLE_NAME;
    }

    /**
     * 헤론의 공식
     * @return
     */
    @Override
    public Double area() {
        Double s = ((perimeter()) / 2);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public Double perimeter() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        return c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }
}
