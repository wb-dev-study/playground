package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;
import ep.blackjack.domain.card.Money;
import ep.blackjack.domain.card.deck.CardDeck;

import java.util.List;

public class Dealer implements User {

    private Hands hands = new Hands();
    private Money revenue = new Money();

    @Override
    public void drawCard(CardDeck cardDeck) {
        Card card = cardDeck.draw();
        this.hands.receiveCard(card);
    }

    @Override
    public Integer handsCardCount() {
        return this.hands.count();
    }

    @Override
    public List<Card> showHandsCard() {
        return this.hands.show();
    }

    @Override
    public Integer sumHandsCard() {
        return this.hands.sum();
    }

    public void addDraw(CardDeck cardDeck) {
        if (this.hands.sum() <= 16) {
            this.drawCard(cardDeck);
        }
    }

    public Boolean addCheck() {
        return this.hands.sum() <= 16;
    }

    @Override
    public List<String> showHandsCardString() {
        return this.hands.showString();
    }

    @Override
    public Money revenue() {
        return this.revenue;
    }

    @Override
    public ResultType result() {
        return this.hands.result();
    }

    @Override
    public void initDrawCard(CardDeck cardDeck) {
        drawCard(cardDeck);
        drawCard(cardDeck);
    }
}
