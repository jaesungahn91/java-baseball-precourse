package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers {

    List<Number> numbers = new ArrayList<>();

    public void setNumbersByStringNumbers(String[] numbers) {
        validateSize(numbers);
        for(String number : numbers) {
            addNumber(new Number(number));
        }
    }

    private void validateSize(String[] numbers) {
        if(numbers.length != ComputerNumbers.MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void addNumber(Number number) {
        this.numbers.add(number);
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
