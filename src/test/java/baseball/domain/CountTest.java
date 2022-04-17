package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {

    @ParameterizedTest
    @CsvSource({"2,1", "2,2", "1,1", "3,1"})
    void 카운트_생성(final int sameNumber, final int strike) {
        Count count = new Count(sameNumber, strike);

        assertThat(count.getStrike()).isEqualTo(strike);
        assertThat(count.getBall()).isEqualTo(sameNumber-strike);
    }

    @Test
    void 게임_종료_플래그_확인() {
        Count count = new Count(3, 3);

        assertThat(count.isGameSet()).isTrue();
    }

}