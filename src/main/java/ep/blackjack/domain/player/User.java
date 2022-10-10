package ep.blackjack.domain.player;

import ep.blackjack.domain.card.deck.CardDeck;

public interface User {

    void drawCard(CardDeck cardDeck);
    Integer handsCardCount();
}

