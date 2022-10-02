package ep.coordinate.figure.component;

import ep.coordinate.figure.Figure;

/**
 * 좌표상의 도형
 * @param <T>
 */
public interface Component<T extends Figure> {

    /**
     * 도형의 형상으로 변환
     * @return T
     */
    T toFigure();
}