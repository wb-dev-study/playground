package ep.racingcar.domain;

import ep.racingcar.domain.strategy.DefaultMovingStrategy;
import ep.racingcar.domain.strategy.MovingStrategy;
import ep.racingcar.exception.RaceException;

import java.util.List;

public class Race {

    private final Participants participants;
    private final Position finishPosition;
    private MovingStrategy movingStrategy;
    private Boolean end = Boolean.FALSE;

    public Race(Participants participants, Integer finishPosition) {
        this.participants = participants;
        this.finishPosition = new Position(finishPosition);
        this.movingStrategy = new DefaultMovingStrategy();
    }

    public Race(Participants participants, Integer finishPosition, MovingStrategy movingStrategy) {
        this.participants = participants;
        this.finishPosition = new Position(finishPosition);
        this.movingStrategy = movingStrategy;
    }

    public void nextRound() {
        if (end) {
            throw new RaceException("이미 마친 끝난 레이스입니다.");
        }
        this.participants.move(this.movingStrategy);
        Position firstPosition = this.participants.currentFirstPosition();
        if (firstPosition.equals(finishPosition)) {
            end = true;
        }
    }

    public Boolean isEnd() {
        return end;
    }

    public void changeMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public List<Car> winners() {
        return this.participants.winners(this.finishPosition);
    }
}
