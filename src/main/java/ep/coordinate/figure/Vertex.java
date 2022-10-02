package ep.coordinate.figure;

import ep.coordinate.Line;
import ep.coordinate.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex {

    private List<Position> positions;

    public Vertex(Position ...positions) {
        this.positions = Arrays.asList(positions);
    }

    public void add(Position position) {
        this.positions.add(position);
    }

    public Integer getVertexSize() {
        return this.positions.size();
    }

    public List<Integer> toXDistinctList() {
        return this.positions.stream().map(Position::getX).distinct().collect(Collectors.toList());
    }

    public List<Integer> toYDistinctList() {
        return this.positions.stream().map(Position::getY).distinct().collect(Collectors.toList());
    }

    public List<Double> eachLength() {
        List<Double> lengthList = new ArrayList<>();

        int size = this.positions.size();
        for (int i = 0; i < size; i ++) {
            if (size == i + 1) {
                Line line = new Line(this.positions.get(i), this.positions.get(0));
                lengthList.add(line.length());
                break;
            }
            Line line = new Line(this.positions.get(i), this.positions.get(i + 1));
            lengthList.add(line.length());
        }
        return lengthList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return positions.equals(vertex.positions);
    }

    @Override
    public int hashCode() {
        return positions.hashCode();
    }
}
