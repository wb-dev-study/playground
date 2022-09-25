package zoey.racingcar;

import zoey.racingcar.domain.Car;
import zoey.racingcar.domain.Drivers;
import zoey.racingcar.domain.RacingGame;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String participants = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(scanner.next());

        Drivers drivers = new Drivers(participants);
        RacingGame racingGame = new RacingGame(drivers);
        IntStream.range(0, count).forEach(i -> {
            racingGame.race().printDriversStatus();
            System.out.println();
        });
        String winners = racingGame.winner().stream().map(Car::getName).collect(Collectors.joining(","));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
