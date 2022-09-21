package hailey.racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요");
        System.out.println("이름은 쉼표(,)를 기준으로 구분해주세요");
        String inputCarNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNumber = scanner.nextInt();
    }
}
