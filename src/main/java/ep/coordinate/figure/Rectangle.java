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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!width.equals(rectangle.width)) return false;
        return height.equals(rectangle.height);
    }

    @Override
    public int hashCode() {
        int result = width.hashCode();
        result = 31 * result + height.hashCode();
        return result;
    }
}
