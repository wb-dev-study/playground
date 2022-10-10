package jay.coordinate.service;

import jay.coordinate.domain.Lines;
import jay.coordinate.domain.Points;

public abstract class Figure {
    public Points points;
    public Lines lines;

    public abstract Double coordinateDistance();
    public abstract void createLines();

    public void setLinesToLinesLength() {
        lines.setLinesToLinesLength();
    }
}
