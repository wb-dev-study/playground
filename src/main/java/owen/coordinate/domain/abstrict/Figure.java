package owen.coordinate.domain.abstrict;

import owen.coordinate.domain.Coordinates;

import java.util.List;

public interface Figure {

    String getName();

    int getSize();

    double calc();

    List<Coordinates> getCoordinates();

}
