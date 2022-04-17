package baseball.domain;

public class GameManager {

    private final ComputerNumbers computerNumbers;

    public GameManager() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void play() {
        computerNumbers.createRandomNumbers();
    }

}
