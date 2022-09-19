package jay.baseball;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean retry = true;

        while (retry) {
            String result = "";
            List<Integer> computer = baseballGame.create();     //컴퓨터 난수 생성
            while (!result.equals("3스트라이크")) {
                System.out.println("숫자를 입력해주세요");
                List<Integer> player = baseballGame.player();   //플레이서 입력값

                int total = baseballGame.total(computer, player);   //자리 상관없이 맞춘 횟수
                int strike = baseballGame.strike(computer, player); //자리 까지 맞춘 횟수
                int ball = total - strike;                          //볼

                if (total == 0) {
                    result = "낫싱";
                } else if (strike == 0) {
                    result = ball + "볼";
                } else if (ball == 0) {
                    result = strike + "스트라이크";
                } else {
                    result = ball + "볼 " + strike + "스트라이크";
                }

                System.out.println(result);
            }
            retry = baseballGame.retry(); //재시작 판단여부
        }
    }
}
