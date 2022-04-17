package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    public static final int MAX_SIZE = 3;

    private List<Number> numbers = new ArrayList<>();

    public ComputerNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public ComputerNumbers() {
    }

    public void createRandomNumbers() {
        while (isLtMaxSize()) {
            addNumber(new Number(createRandomNumber()));
        }
    }

    private boolean isLtMaxSize() {
        return this.numbers.size() < MAX_SIZE;
    }

    private void addNumber(Number number) {
        if(!isDuplicated(number)) {
            this.numbers.add(number);
        }
    }

    private Integer createRandomNumber() {
        return Randoms.pickNumberInRange(Number.MIN_RANGE, Number.MAX_RANGE);
    }

    private boolean isDuplicated(Number number) {
        return this.numbers.contains(number);
    }

    public int getSize() {
        return this.numbers.size();
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }

    public Count checkCountWithPlayerNumbers(PlayerNumbers playerNumbers) {
        int sameNumber = getSameNumber(playerNumbers);
        int strike = getStrike(playerNumbers);

        return new Count(sameNumber, strike);
    }

    private int getSameNumber(PlayerNumbers playerNumbers) {
        int count = 0;
        for(Number number : playerNumbers.getNumbers()) {
            count += countSameNumber(number);
        }
        return count;
    }

    private int countSameNumber(Number number) {
        return isDuplicated(number) ? 1 : 0;
    }

    private int getStrike(PlayerNumbers playerNumbers) {
        int count = 0;
        int placeIndex = 0;
        for(Number number : playerNumbers.getNumbers()) {
            count += countStrike(placeIndex, number);
            placeIndex += 1;
        }
        return count;
    }

    private int countStrike(int placeIndex, Number number) {
        return this.numbers.get(placeIndex).equals(number) ? 1 : 0;
    }

}
