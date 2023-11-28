package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallLocationTest {
    @DisplayName("유효하지 않은 입력값에 대한 예외 발생 확인")
    @ParameterizedTest(name = "위치값이 {0}인 경우")
    @ValueSource(ints = {-1, 3})
    void constructor_WithInvalidInput_ThrowsError(int location) {
        assertThatThrownBy(() -> new BallLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공의 위치 범위를 초과");
    }
}