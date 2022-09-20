package jay.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    public boolean retry() {
        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if (c == '1') {
            return true;
        }
        return false;
    }

    public List<Integer> player() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> player = new ArrayList<>();
        String input = scanner.next();

        for (String number : input.split("")) {
            player.add(Integer.parseInt(number));
        }
        return player;
    }
}
