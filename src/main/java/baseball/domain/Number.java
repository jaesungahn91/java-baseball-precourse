package baseball.domain;

public class Number {

    public static final Integer MIN_RANGE = 1;
    public static final Integer MAX_RANGE = 9;

    private final Integer value;

    public Number(Integer value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(Integer value) {
        if(value < MIN_RANGE || value > MAX_RANGE) {
           throw new IllegalArgumentException();
        }
    }

}
