package peter.racingcar.view;

import peter.racingcar.domain.Game;
import peter.racingcar.domain.GameEntryInput;

import java.util.Scanner;

/**
 * Created by peter on 2022/09/25
 */
public class RacingGameView {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String entry = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String round = scanner.nextLine();
        GameEntryInput gameEntryInput = new GameEntryInput(entry, round);

        Game racingGame = new Game(gameEntryInput);
        racingGame.play();
    }
}
