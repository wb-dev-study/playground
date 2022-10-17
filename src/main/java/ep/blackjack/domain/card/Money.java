package ep.blackjack.domain.card;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount = BigDecimal.ZERO;

    public Money() {

    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public void add(BigDecimal addAmount) {
        this.amount = this.amount.add(addAmount);
    }

    public BigDecimal amount() {
        return this.amount;
    }
}

