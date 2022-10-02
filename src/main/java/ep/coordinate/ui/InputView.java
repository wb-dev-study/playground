package ep.coordinate.ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println("좌표를 입력하세요");
        return scanner.nextLine();
    }
}
