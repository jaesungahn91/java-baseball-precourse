package baseball.application;

import baseball.domain.ComputerNumbers;
import baseball.domain.PlayerNumbers;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private static final String ASK_NUMBER_MESSAGE = "숫자를입력해주세요 : ";

    private final ComputerNumbers computerNumbers;

    public GameManager() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void play() {
        computerNumbers.createRandomNumbers();

        PlayerNumbers playerNumbers = new PlayerNumbers();
        playerNumbers.setNumbersByStringNumbers(askPlayerNumber());
    }

    private String[] askPlayerNumber() {
        System.out.print(ASK_NUMBER_MESSAGE);
        return Console.readLine().split("");
    }

}
