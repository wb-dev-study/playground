package ep.racingcar.view;

import ep.racingcar.domain.Board;
import ep.racingcar.domain.Car;
import ep.racingcar.domain.Participants;
import ep.racingcar.domain.Race;
import ep.racingcar.domain.strategy.RandomMovingStrategy;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ResultView {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String carNames = scanner.nextLine();
        List<Car> cars = new StringToCar(carNames).toCars();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int finalRound = Integer.parseInt(scanner.nextLine());
        Race race = new Race(new Participants(cars), finalRound);
        race.changeMovingStrategy(new RandomMovingStrategy());
        while (race.processing()) {
            Board currentBoard = race.currentBoard();
            currentBoard.getCurrentCarData().forEach((data) -> {
                String process = currentProcess(data.getPosition());
                System.out.println(data.getCarName() + " : " + process);
            });
            System.out.println();
            race.nextRound();
        }
        List<Car> winners = race.winners();
        String winnersNames = getWinnersName(winners);
        System.out.println(winnersNames + "가 최종 우승했습니다.");

    }

    private String getWinnersName(List<Car> winners) {
        StringJoiner stringJoiner = new StringJoiner(",");
        winners.forEach((car) -> {
            stringJoiner.add(car.name());
        });
        return stringJoiner.toString();
    }

    private String currentProcess(Integer position)  {
        StringBuilder process = new StringBuilder();
        process.append(">".repeat(Math.max(0, position)));
        return process.toString();
    }

}
