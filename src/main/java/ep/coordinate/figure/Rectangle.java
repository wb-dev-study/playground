package ep.coordinate.figure;

public class Rectangle implements Figure {

    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("직사각형이 되지 못하는 조건입니다.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public Double area() {
        return (double) (this.width * this.height);
    }

    @Override
    public Double perimeter() {
        return (double) (this.width * 2 + this.height * 2);
    }
}
