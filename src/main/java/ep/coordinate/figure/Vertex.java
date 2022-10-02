package ep.coordinate.figure;

import ep.coordinate.Position;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Vertex {

    private Set<Position> positions = new LinkedHashSet<>();

    public Vertex(Position ...positions) {
        this.positions = new LinkedHashSet<>(Arrays.asList(positions));
    }

    public void add(Position position) {
        this.positions.add(position);
    }

    public Integer getVertexSize() {
        return this.positions.size();
    }

    public List<Integer> toXList() {
        return this.positions.stream().map(Position::getX).distinct().collect(Collectors.toList());
    }

    public List<Integer> toYList() {
        return this.positions.stream().map(Position::getY).distinct().collect(Collectors.toList());
    }
}
