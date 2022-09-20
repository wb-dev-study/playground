package jay.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerNumber {
    public List<Integer> create() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> player = new ArrayList<>();
        String input = scanner.next();

        for (String number : input.split("")) {
            player.add(Integer.parseInt(number));
        }
        return player;
    }
}
