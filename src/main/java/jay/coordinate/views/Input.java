package jay.coordinate.views;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCoordinate() {
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine();
    }
}
