package jay.baseball;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerNumber playerNumber = new PlayerNumber();
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        BaseballBatsman baseballBatsman = new BaseballBatsman();
        Restart restart = new Restart();

        boolean retry = true;

        while (retry) {
            String result = "";
            List<Integer> computer = computerRandomNumber.create();     //컴퓨터 난수 생성
            while (!result.equals("3스트라이크")) {
                System.out.println("숫자를 입력해주세요");
                List<Integer> player = playerNumber.create();   //플레이서 입력값

                int total = baseballBatsman.total(computer, player);   //자리 상관없이 맞춘 횟수
                int strike = baseballBatsman.strike(computer, player); //자리 까지 맞춘 횟수
                int ball = baseballBatsman.ball(total,strike);         //볼

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
            retry = restart.retry(); //재시작 판단여부
        }
    }
}
