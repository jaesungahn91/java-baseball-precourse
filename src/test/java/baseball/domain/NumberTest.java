package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 예외테스트_범위_이외의_숫자_생성(final int value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}