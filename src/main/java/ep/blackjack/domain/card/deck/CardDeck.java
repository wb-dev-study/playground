package ep.blackjack.domain.card.deck;

import ep.blackjack.domain.card.Card;

public interface CardDeck {
    Integer size();
    Card draw();
}
