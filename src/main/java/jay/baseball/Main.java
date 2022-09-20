package jay.baseball;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerNumber baseballGame = new PlayerNumber();
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        BaseballBatsman baseballBatsman = new BaseballBatsman();
        Restart restart = new Restart();

        boolean retry = true;

        while (retry) {
            String result = "";
            List<Integer> computer = computerRandomNumber.create();     //컴퓨터 난수 생성
            computer.forEach(e-> System.out.println(e));
            while (!result.equals("3스트라이크")) {
                System.out.println("숫자를 입력해주세요");
                List<Integer> player = baseballGame.create();   //플레이서 입력값

                int total = baseballBatsman.total(computer, player);   //자리 상관없이 맞춘 횟수
                int strike = baseballBatsman.strike(computer, player); //자리 까지 맞춘 횟수
                int ball = baseballBatsman.ball(total,strike);         //볼

                result = baseballBatsman.baseballResult(total, strike, ball);
                System.out.println(result);
            }
            retry = restart.retry(); //재시작 판단여부
        }
    }
}
