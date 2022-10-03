package jay.baseball;

import java.util.Scanner;

public class Restart {
    public boolean retry() {
        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if (c == '1') {
            return true;
        }
        return false;
    }
}
