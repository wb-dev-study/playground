package ep.blackjack.ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String participatePlayer() {
        return input("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static String betPlayer(String playerName) {
        return input(playerName + "의 배팅 금액은?");
    }

    public static String addDrawCard(String playerName) {
        return input(playerName + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    private static String input(String content) {
        System.out.println(content);
        return scanner.nextLine();
    }
}
