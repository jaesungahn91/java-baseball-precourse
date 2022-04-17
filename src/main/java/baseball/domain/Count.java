package baseball.domain;

public class Count {

    private final Integer sameNumber;
    private final Integer strike;
    private final Integer ball;

    public Count(Integer sameNumber, Integer strike) {
        this.sameNumber = sameNumber;
        this.strike = strike;
        this.ball = sameNumber - strike;
    }

    public Integer getSameNumber() {
        return sameNumber;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isGameSet() {
        return strike == ComputerNumbers.MAX_SIZE;
    }
}
