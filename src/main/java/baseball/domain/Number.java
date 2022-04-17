package baseball.domain;

import java.util.Objects;

public class Number {

    public static final Integer MIN_RANGE = 1;
    public static final Integer MAX_RANGE = 9;
    private static final String CHANGE_NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    private final Integer value;

    public Number(Integer value) {
        validateRange(value);
        this.value = value;
    }

    public Number(String value) {
        validateNumber(value);
        validateRange(Integer.valueOf(value));
        this.value = Integer.valueOf(value);
    }

    private void validateRange(Integer value) {
        if(value < MIN_RANGE || value > MAX_RANGE) {
           throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String value) {
        if(!value.matches(CHANGE_NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
