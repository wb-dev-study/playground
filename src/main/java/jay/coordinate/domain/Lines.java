package jay.coordinate.domain;

import jay.coordinate.domain.figure.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines{
    public final List<Line> lines;
    public List<Double> linesLength;

    public Lines() {
        this.lines =  new ArrayList<>();
        this.linesLength =  new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void setLinesToLinesLength(){
        for(Line line : lines){
            addLinesLength(line.coordinateDistance());
        }
    }

    public void addLinesLength(double length){
        linesLength.add(length);
    }

    public List<Double> getLinesLength(){
        return this.linesLength;
    }
}