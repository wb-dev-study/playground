package ep.blackjack.domain.card;

import ep.blackjack.domain.enums.CardType;
import ep.blackjack.domain.enums.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {


    @Test
    @DisplayName("카드 생성")
    void create_card() {
        Card card = new Card(CardType.DIAMOND, CardValue.ACE);
        assertThat(card).isNotNull();
    }
}
