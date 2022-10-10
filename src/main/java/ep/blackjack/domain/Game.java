package ep.blackjack.domain;

import ep.blackjack.domain.card.Card;
import ep.blackjack.domain.card.deck.CardDeck;
import ep.blackjack.domain.card.deck.StandardCardDeck;
import ep.blackjack.domain.player.Dealer;
import ep.blackjack.domain.player.Player;
import ep.blackjack.domain.player.ResultType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game {

    private final static Double WIN_RATE = 2.0;


    private CardDeck cardDeck = new StandardCardDeck();
    private Dealer dealer = new Dealer();
    private List<Player> players;

    public List<Player> players() {
        return this.players;
    }

    public Dealer dealer() {
        return this.dealer;
    }

    public CardDeck cardDeck() {
        return this.cardDeck;
    }

    public void participatePlayer(List<Player> playerList) {
        this.players = playerList;
    }

    public List<String> playerNames() {
        return this.players.stream().map(Player::name).collect(Collectors.toList());
    }

    public List<String> dealerCard() {
        return this.dealer.showHandsCard().stream().map(Card::showString).collect(Collectors.toList());
    }

    public void complete() {
        Integer dealerSum = this.dealer.sumHandsCard();
        ResultType result = this.dealer.result();
        for (Player player : players) {
            switch (result) {
                case UNDER: {
                    if (player.result() != ResultType.OVER && player.sumHandsCard() > dealerSum) {
                        player.win(WIN_RATE);
                        break;
                    }

                    if (player.result() != ResultType.OVER && Objects.equals(player.sumHandsCard(), dealerSum)) {
                        player.draw();
                        break;
                    }
                    player.lose();
                    this.dealer.revenue().add(player.loseBetAmount());
                    break;
                }
                case BLACK_JAK: {
                    if (player.result() == ResultType.BLACK_JAK) {
                        player.draw();
                        break;
                    }
                    player.lose();
                    this.dealer.revenue().add(player.loseBetAmount());
                    break;
                }
                case OVER: {
                    player.win(WIN_RATE);
                    break;
                }
                default: {
                    player.lose();
                    this.dealer.revenue().add(player.loseBetAmount());
                    break;
                }
            }
        }
    }
}