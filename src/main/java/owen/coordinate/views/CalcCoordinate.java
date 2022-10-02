package owen.coordinate.views;

import owen.coordinate.FigureFactory;
import owen.coordinate.domain.Points;
import owen.coordinate.domain.abstrict.Figure;
import owen.coordinate.utils.CoordinateUtils;

import java.util.List;
import java.util.Scanner;

public class CalcCoordinate {

    private final Scanner scanner = new Scanner(System.in);

    public void playGame() {
        System.out.println("좌표를 입력하세요");
        String userInput = scanner.nextLine();
        List<List<Integer>> convert = CoordinateUtils.convert(userInput);
        Points points = new Points(convert);

        FigureFactory figureFactory = new FigureFactory();
        Figure figure = figureFactory.createFigure(points);
        double calc = figure.calc();
        System.out.println("결과 = " + calc);


    }
}
