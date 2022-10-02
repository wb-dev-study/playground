package ep.coordinate.figure.component;

import ep.coordinate.figure.Figure;

/**
 * 좌표상의 도형
 * @param <T>
 */
public interface Component<T extends Figure> {

    T toFigure();
}