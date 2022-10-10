package ep.blackjack.domain.player;

import ep.blackjack.domain.card.Card;
import ep.blackjack.domain.card.Money;
import ep.blackjack.domain.card.deck.CardDeck;

import java.math.BigDecimal;
import java.util.List;

public class Player implements User {

    private String name;
    private Hands hands = new Hands();
    private Money bet = new Money();
    private Money revenue = new Money();

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public void drawCard(CardDeck deck) {
        if (this.sumHandsCard() > 21) {
            throw new IllegalStateException("이미 손에 쥔 카드가 21을 넘었습니다.");
        }
        Card card = deck.draw();
        this.hands.receiveCard(card);
    }

    @Override
    public Integer handsCardCount() {
        return this.hands.count();
    }

    public void bet(BigDecimal amount) {
        this.bet.add(amount);
    }

    public BigDecimal betAmount() {
        return this.bet.amount();
    }

    @Override
    public List<Card> showHandsCard() {
        return this.hands.show();
    }

    @Override
    public Integer sumHandsCard() {
        return this.hands.sum();
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

    public void draw() {
        this.revenue = this.bet;
    }

    public void lose() {
        this.revenue = new Money(BigDecimal.ZERO.subtract(this.bet.amount()));
    }

    public BigDecimal loseBetAmount() {
        return this.bet.amount();
    }

    public void win(Double multiply) {
        this.revenue = new Money(BigDecimal.valueOf((long) betAmount().intValue() * multiply));
    }
}
