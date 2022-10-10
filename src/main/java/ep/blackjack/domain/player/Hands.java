package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hands {
    private List<Card> cardList = new ArrayList<>();

    public Integer count() {
        return this.cardList.size();
    }

    public void receiveCard(Card card) {
        this.cardList.add(card);
    }
}
