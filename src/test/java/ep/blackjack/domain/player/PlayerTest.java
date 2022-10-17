package ep.blackjack.domain.player;

import ep.blackjack.domain.card.deck.CardDeck;
import ep.blackjack.domain.card.deck.StandardCardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private CardDeck cardDeck;
    private Player player;

    @BeforeEach
    void setUp() {
        this.cardDeck = new StandardCardDeck();
        this.player = new Player("ep");
    }

    @Test
    @DisplayName("손에 든 패 카운트")
    void drawCount() {
        assertThat(player.handsCardCount()).isZero();
        player.drawCard(this.cardDeck);
        assertThat(player.handsCardCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("베팅")
    void bet() {
        this.player.bet(BigDecimal.valueOf(1000));
        assertThat(player.betAmount()).isEqualTo(BigDecimal.valueOf(1000));
    }
}