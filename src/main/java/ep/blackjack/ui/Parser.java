package ep.blackjack.ui;

import ep.blackjack.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Player> parsePlayerNames(String names) {
        String[] splitName = names.split(",");
        List<Player> playerList = new ArrayList<>();
        for (String name: splitName) {
            playerList.add(new Player(name));
        }
        return playerList;
    }

    public static Boolean parseBetAnswer(String answer) {
        if (answer.equalsIgnoreCase("y")) {
            return true;
        }

        if (answer.equalsIgnoreCase("n")) {
            return false;
        }

        throw new IllegalArgumentException("답변 형식이 올바르지 않습니다.");
    }
}
