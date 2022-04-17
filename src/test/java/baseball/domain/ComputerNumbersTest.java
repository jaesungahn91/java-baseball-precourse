package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumbersTest {

    @Test
    void 랜덤한_3자리의_컴퓨터_숫자_생성() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        computerNumbers.createRandomNumbers();

        assertThat(computerNumbers.getSize()).isEqualTo(ComputerNumbers.MAX_SIZE);
        assertThat(computerNumbers.getNumbers()).doesNotHaveDuplicates();
    }

}