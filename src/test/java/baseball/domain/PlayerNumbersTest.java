package baseball.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "671", "111", "789"})
    void 플레이어_3자리의_숫자_생성(final String numbers) {
        String[] numberArr = numbers.split("");

        PlayerNumbers playerNumbers = new PlayerNumbers();
        playerNumbers.setNumbersByStringNumbers(numberArr);

        assertThat(playerNumbers.getNumbers()).containsExactly(new Number(numberArr[0]),
                new Number(numberArr[1]),
                new Number(numberArr[2]));
    }

}