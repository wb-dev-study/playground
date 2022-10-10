package ep.blackjack.domain.player;

import ep.blackjack.domain.card.deck.CardDeck;
import ep.blackjack.domain.card.deck.StandardCardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        this.cardDeck = new StandardCardDeck();
    }

    @Test
    @DisplayName("손에 든 패 카운트")
    void drawCount() {
        Dealer dealer = new Dealer();
        assertThat(dealer.handsCardCount()).isZero();
        dealer.drawCard(this.cardDeck);
        assertThat(dealer.handsCardCount()).isEqualTo(1);
    }
}
