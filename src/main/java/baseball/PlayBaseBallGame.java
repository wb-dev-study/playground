package baseball;

import java.util.*;

import static baseball.ValidationUtils.checkNotDuplicate;

public class PlayBaseBallGame {
    Scanner scanner = new Scanner(System.in);

    public void startGame() {

        //게임전체반복
        while(true) {
            List<Ball> answerBall = makeRandomBall();

            while(true) {
                //사용자로부터 3개의 정수를 입력받는다.
                System.out.println("3개의정수를 입력하세요(1~9)");
                System.out.println("스페이스로 구분하시고 마지막에 Enter를 눌러주세요");
                int userBall1 = scanner.nextInt();
                int userBall2 = scanner.nextInt();
                int userBall3 = scanner.nextInt();

                List<Ball> userBalls;
                if (checkNotDuplicate(userBall1, userBall2, userBall3)) {
                    userBalls = Ball.makeBall(Arrays.asList(userBall1, userBall2, userBall3));
                } else {
                    continue;
                }

                PlayResult playResult = matchAnswer(answerBall, userBalls);

                if (playResult.isGameEnd()) {
                    System.out.println("3스트라이크 게임종료");
                    break;
                }
                System.out.printf("%d스트라이크, %d볼\n", playResult.getStrike(), playResult.getBall());
            }
            finishGame();
        }
    }

    public List<Ball> makeRandomBall() {
        Random random = new Random();
        //중복되지 않는 3개의 난수생성
        while (true) {
            int first = random.nextInt(100) % 9 + 1;
            int second = random.nextInt(100) % 9 + 1;
            int third = random.nextInt(100) % 9 + 1;
            if(checkNotDuplicate(first, second, third)) {
                return Ball.makeBall(Arrays.asList(first, second, third));
            }
        }
    }

    private PlayResult matchAnswer(List<Ball> answerBalls, List<Ball> usesrBalls) {
        PlayResult playResult = new PlayResult();
        for (Ball answer : answerBalls) {
            playResult.report(compareAnswer(usesrBalls, answer));
        }
        return playResult;
    }
    private BallStatus compareAnswer(List<Ball> usesrBalls, Ball answer) {
        return usesrBalls.stream()
                .map(answerBall -> answerBall.compareAnswer(answer))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse((BallStatus.NOTHING));
    }

    private void finishGame() {
        System.out.println("한게임 더 하시겠습니까?(0:종료,1:재시작)");
        int restart = scanner.nextInt();
        if(restart==0) {
            System.out.println("\n==게임이 종료되었습니다.==\n");
            System.exit(0);
        }
        else if(restart==1){
            System.out.println("\n==게임을 재시작합니다.==\n");
        }
    }
}
