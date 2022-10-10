package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;
import ep.blackjack.domain.card.deck.CardDeck;

import java.util.List;

public interface User {

    void drawCard(CardDeck cardDeck);
    Integer handsCardCount();
    List<Card> showHandsCard();
}
