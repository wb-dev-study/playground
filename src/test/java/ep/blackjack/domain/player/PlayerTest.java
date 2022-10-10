package ep.blackjack.domain.player;

import ep.blackjack.domain.card.deck.CardDeck;
import ep.blackjack.domain.card.deck.StandardCardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        this.cardDeck = new StandardCardDeck();
    }

    @Test
    @DisplayName("손에 든 패 카운트")
    void drawCount() {
        Player player = new Player();
        assertThat(player.handsCardCount()).isEqualTo(0);
        player.drawCard(this.cardDeck);
        assertThat(player.handsCardCount()).isEqualTo(1);
    }
}

