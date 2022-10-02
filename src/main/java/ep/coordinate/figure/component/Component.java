package ep.coordinate.figure.component;

import ep.coordinate.figure.Figure;

public interface Component<T extends Figure> {

    T toFigure();
}