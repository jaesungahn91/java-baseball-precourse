package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    public static final int MAX_SIZE = 3;

    private final List<Number> numbers = new ArrayList<>();

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
}
