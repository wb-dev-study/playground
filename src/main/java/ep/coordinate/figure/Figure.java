package ep.coordinate.figure;

/**
 * 도형의 형상
 */
public interface Figure {

    /**
     * 도형의 이름
     * @return String
     */
    String name();

    /**
     * 도형의 넓이
     * @return Double
     */
    Double area();

    /**
     * 도형의 둘레
     * @return Double
     */
    Double perimeter();
}
