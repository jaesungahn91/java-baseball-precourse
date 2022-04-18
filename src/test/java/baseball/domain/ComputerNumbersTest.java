package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumbersTest {

    @Test
    void 서로다른_랜덤한_3자리의_컴퓨터_숫자_생성() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        computerNumbers.createRandomNumbers();

        assertThat(computerNumbers.getSize()).isEqualTo(ComputerNumbers.MAX_SIZE);
        assertThat(computerNumbers.getNumbers()).doesNotHaveDuplicates();
    }

    @ParameterizedTest
    @CsvSource({"132,1,2", "123,3,0", "456,0,0", "312,0,3"})
    void 볼_스트라이크_확인(final String numbers, final int strike, final int ball) {
        PlayerNumbers playerNumbers = new PlayerNumbers();
        playerNumbers.setNumbersByStringNumbers(numbers.split(""));

        ComputerNumbers computerNumbers = new ComputerNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3)));

        Count count = computerNumbers.checkCountWithPlayerNumbers(playerNumbers);

        assertThat(strike).isEqualTo(count.getStrike());
        assertThat(ball).isEqualTo(count.getBall());
    }

}