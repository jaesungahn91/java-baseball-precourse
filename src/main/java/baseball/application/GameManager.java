package baseball.application;

import baseball.domain.ComputerNumbers;
import baseball.domain.Count;
import baseball.domain.PlayerNumbers;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private static final String ASK_NUMBER_MESSAGE = "숫자를입력해주세요 : ";
    private static final String NOTING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String ENDING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final ComputerNumbers computerNumbers;
    private boolean gameContinueFlag = true;

    public GameManager() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void play() {
        computerNumbers.createRandomNumbers();

        boolean gameSetFlag = false;
        while(!gameSetFlag) {
            PlayerNumbers playerNumbers = new PlayerNumbers();
            playerNumbers.setNumbersByStringNumbers(askPlayerNumber());

            Count count = computerNumbers.checkCountWithPlayerNumbers(playerNumbers);
            printResultCount(count);

            gameSetFlag = count.isGameSet();
        }

        System.out.println(ENDING_MESSAGE);

        askContinue();
    }

    private String[] askPlayerNumber() {
        System.out.print(ASK_NUMBER_MESSAGE);
        return Console.readLine().split("");
    }

    private void printResultCount(Count count) {
        if(count.getSameNumber() == 0) {
            System.out.println(NOTING_MESSAGE);
            return;
        }
        if(count.getBall() > 0) {
            System.out.println(count.getBall() + BALL_MESSAGE + " " + count.getStrike() + STRIKE_MESSAGE);
            return;
        }
        System.out.println(count.getStrike() + STRIKE_MESSAGE);
    }

    public void askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(!Console.readLine().equals("1")) {
            this.gameContinueFlag = false;
        }
    }

    public boolean isGameContinue() {
        return this.gameContinueFlag;
    }
}
