package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;
import ep.blackjack.domain.card.deck.CardDeck;

public class Dealer implements User {

    private Hands hands = new Hands();

    @Override
    public void drawCard(CardDeck cardDeck) {
        Card card = cardDeck.draw();
        this.hands.receiveCard(card);
    }

    @Override
    public Integer handsCardCount() {
        return this.hands.count();
    }
}
