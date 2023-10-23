package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    final Validation validation = new Validation();

    public List<Integer> createRandomNumber() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
            if (!computerNums.contains(num)) {
                computerNums.add(num);
            }
        }
        return computerNums;
    }

    public int[] judgeStrikeOrBall(List<Integer> computerNums, String userNums) {
        int[] strikeBallNums = new int[2];
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = computerNums.get(i);
            int userNum = Integer.parseInt(userNums.substring(i,i+1));

            if (computerNum == userNum) {
                strikeCnt++;
            }
            else if (computerNums.contains(userNum)) {
                ballCnt++;
            }
        }
        strikeBallNums[0] = strikeCnt;
        strikeBallNums[1] = ballCnt;

        return strikeBallNums;
    }

    public void showResult(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
        else if (strike > 0 && ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        }
        else if (strike == 0 && ball > 0) {
            System.out.println(String.format("%d볼", ball));
        }
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean checkRestart() {
        boolean flag = false;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userAnswer = camp.nextstep.edu.missionutils.Console.readLine();
        validation.isValidate(userAnswer, "game over");

        if (userAnswer.equals("1")) {
            flag = true;
        }

        return flag;
    }
}
