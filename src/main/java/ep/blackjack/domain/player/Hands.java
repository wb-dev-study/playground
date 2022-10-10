package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hands {
    private List<Card> cardList = new ArrayList<>();

    public Integer count() {
        return this.cardList.size();
    }

    public void receiveCard(Card card) {
        this.cardList.add(card);
    }

    public List<Card> show() {
        return this.cardList;
    }

    public List<String> showString() {
        return this.cardList.stream()
                .map(Card::showString)
                .collect(Collectors.toList());
    }

    public Integer sum() {
        return this.cardList.stream()
                .map(Card::getNumber)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public ResultType result() {
        Integer sum = sum();
        if (sum > 21) {
            return ResultType.OVER;
        }

        if (sum == 21) {
            return ResultType.BLACK_JAK;
        }
        return ResultType.UNDER;
    }
}
