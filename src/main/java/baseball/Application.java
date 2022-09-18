package baseball;

import baseball.domain.BallGame;
import baseball.domain.BallGameResult;
import baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> computers = numberGenerator.createRandomNumbers();
        while (true) {
            BallGameResult ballGameResult = new BallGame(computers, getPlayerNumbers()).play();
            System.out.println(ballGameResult.getResult());
            if (ballGameResult.isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> getPlayerNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 >> ");
        String input = scanner.next();
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
