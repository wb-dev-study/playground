package ep.blackjack.domain.card;

import ep.blackjack.domain.card.deck.CardDeck;
import ep.blackjack.domain.card.deck.StandardCardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StandardCardDeckTest {

    private CardDeck cardDeck;
    private final static Integer INIT_CARD_DECK_SIZE = 52;

    @BeforeEach
    void setUp() {
        this.cardDeck = new StandardCardDeck();
    }

    @Test
    @DisplayName("카드 덱 생성이 잘 되는지")
    void create_card_deck() {
        assertThat(cardDeck.size()).isEqualTo(INIT_CARD_DECK_SIZE);
    }

    @Test
    @DisplayName("카드 뽑기")
    void draw() {
        Card firstCard = cardDeck.draw();
        assertThat(cardDeck.size()).isEqualTo(INIT_CARD_DECK_SIZE - 1);
        Card secondCard = cardDeck.draw();
        assertThat(firstCard).isNotEqualTo(secondCard);
        assertThat(cardDeck.size()).isEqualTo(INIT_CARD_DECK_SIZE - 2);
    }
}
