package baseball.application;

import baseball.domain.ComputerNumbers;

public class GameManager {

    private final ComputerNumbers computerNumbers;

    public GameManager() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void play() {
        computerNumbers.createRandomNumbers();
    }

}
