package owen.racingcar.view;

import owen.racingcar.domain.GameResult;
import owen.racingcar.utils.RacingUtils;
import owen.racingcar.domain.car.Cars;
import owen.racingcar.domain.RandomRacing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameView {

    public static final Scanner scanner = new Scanner(System.in);

    public void play() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] split = scanner.nextLine().split(",");
        List<String> carNameList = Arrays.stream(split).collect(Collectors.toList());

        /**
         * 레이싱할 자동차 List 생성
         */
        Cars cars = new Cars(carNameList);

        /**
         * 랜덤 레이싱 시작
         */
        System.out.println("시도할 회수는 몇회인가요?");
        String gameTry = scanner.nextLine();
        RandomRacing randomRacing = new RandomRacing(cars,  RacingUtils.parseInteger(gameTry));
        randomRacing.startRandomRacing();

        /**
         * 우승자 결과 도출
         */
        GameResult gameResult = new GameResult(cars);
        gameResult.checkWinner();
        System.out.println(gameResult.getWinnerName() + " 가 최종 우승했습니다.");
    }
}
