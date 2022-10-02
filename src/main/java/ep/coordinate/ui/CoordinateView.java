package ep.coordinate.ui;

import ep.coordinate.CoordinateFactory;
import ep.coordinate.figure.material.Position;
import ep.coordinate.figure.Figure;

import java.util.List;

// (10,10)-(22,10)-(22,18)-(10,18) 96.0
// (1,3)-(2,5)-(6,5) 4.0000000000000036
public class CoordinateView {
    public static void main(String[] args) {
        String input = InputView.input();
        List<Position> positions = CoordinateParser.parse(input);
        CoordinateFactory coordinateFactory = new CoordinateFactory(positions);
        Figure figure = coordinateFactory.figure();
        OutputView.output(figure.name(), figure.area());
    }
}
