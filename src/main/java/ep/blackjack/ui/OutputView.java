package ep.blackjack.ui;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void draw(List<String> playerNames) {
        String string = join(playerNames);
        output("딜러와 " + string + "에게 2장의 나누었습니다.");
    }

    private static String join(List<String> strings) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String string: strings) {
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }

    private static void output(String content) {
        System.out.println(content);
    }

    public static void drawResult(String name, List<String> showHandsCard) {
        output(name + ": " + join(showHandsCard));
        System.out.println();
    }

    public static void dealerAddDraw() {
        output("딜러는 1이하라 한장의 카드를 더 받았습니다.");
        System.out.println();
    }

    public static void result(String name, List<String> showHandsCardString, Integer sumHandsCard) {
        output(name + " 카드 : " + showHandsCardString + " - 결과: " + sumHandsCard);
        System.out.println();
    }

    public static void finalRevenue() {
        output("## 최종 수익");
        System.out.println();
    }

    public static void finalPlayerRevenue(String name, Integer revenue) {
        output(name + ": " + revenue * 2);
    }

    public static void finalDealerRevenue(Integer balance) {
        output("딜러: " + balance);
    }
}
