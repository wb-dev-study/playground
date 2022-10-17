package ep.blackjack.ui;

import ep.blackjack.domain.Game;
import ep.blackjack.domain.player.Player;

import java.math.BigDecimal;
import java.util.List;

public class GameView {

    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.start();
    }

    private final Game game = new Game();

    public void start() {
        participatePlayer();

        bet();

        draw();

        addDraw();

        dealerHandsCheck();

        result();

        finalRevenue();
    }

    private void result() {
        OutputView.result("딜러", this.game.dealer().showHandsCardString(), this.game.dealer().sumHandsCard());
        this.game.players().forEach(player -> OutputView.result(player.name(), player.showHandsCardString(), player.sumHandsCard()));
    }

    private void participatePlayer() {
        String participatePlayerNames = InputView.participatePlayer();
        List<Player> playerList = Parser.parsePlayerNames(participatePlayerNames);
        game.participatePlayer(playerList);
    }

    private void bet() {
        this.game.players().forEach(player -> {
            String betAmount = InputView.betPlayer(player.name());
            player.bet(BigDecimal.valueOf(Integer.parseInt(betAmount)));
        });
    }

    private void draw() {
        List<String> playerNames = this.game.playerNames();
        OutputView.draw(playerNames);
        this.game.dealer().initDrawCard(this.game.cardDeck());
        OutputView.drawResult("딜러", this.game.dealerCard());
        this.game.players().forEach(player -> player.initDrawCard(this.game.cardDeck()));
        this.game.players().forEach(player -> OutputView.drawResult(player.name(), player.showHandsCardString()));
    }

    private void addDraw() {
        for (Player player : this.game.players()) {
            String answer = InputView.addDrawCard(player.name());
            boolean answerBoolean = Parser.parseBetAnswer(answer);
            if (answerBoolean) {
                player.drawCard(this.game.cardDeck());
            }
        }
    }

    public void dealerHandsCheck() {
        if (this.game.dealer().addCheck()) {
            OutputView.dealerAddDraw();
            this.game.dealer().addDraw(this.game.cardDeck());
        }
    }

    private void finalRevenue() {
        OutputView.finalRevenue();
        this.game.complete();
        OutputView.finalDealerRevenue(this.game.dealer().revenue().amount().intValue());
        this.game.players().forEach(player -> OutputView.finalPlayerRevenue(player.name(), player.revenue().amount().intValue()));
    }
}
