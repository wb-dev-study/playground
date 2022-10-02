package ep.coordinate.figure;

import ep.coordinate.figure.component.RectangleComponent;

import java.util.List;
import java.util.Set;

public class Rectangle implements Figure {

    private List<Integer> xList;
    private List<Integer> yList;

    public Rectangle(List<Integer> xSet, List<Integer> ySet) {
        if (xSet.size() != 2 || ySet.size() != 2) {
            throw new IllegalArgumentException("직사각형이 되지 못하는 조건입니다.");
        }
        this.xList = xSet;
        this.yList = ySet;
    }

    @Override
    public Double area() {
        return (double) (Math.abs(xList.get(0) - xList.get(1)) * Math.abs(yList.get(0) - yList.get(1)));
    }
}
