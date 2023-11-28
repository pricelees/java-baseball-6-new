package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {
    @DisplayName("1부터 9 사이의 값이 아닐 때의 예외 발생 확인")
    @ParameterizedTest(name = "숫자가 {0}인 경우")
    @ValueSource(ints = {0, 10})
    void constructor_WithInvalidInput_ThrowsError(int number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 범위를 초과");
    }
}