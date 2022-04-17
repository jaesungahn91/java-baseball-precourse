package baseball.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "671", "111", "789"})
    void 플레이어_3자리의_숫자_생성(final String numbers) {
        PlayerNumbers playerNumbers = new PlayerNumbers();
        playerNumbers.setNumbersByStringNumbers(numbers.split(""));

        assertThat(playerNumbers.getNumbers()).containsExactly(new Number(numbers.split("")[0]),
                new Number(numbers.split("")[1]),
                new Number(numbers.split("")[2]));
    }

}