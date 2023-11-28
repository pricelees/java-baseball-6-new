package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Ball;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsConverterTest {
    @DisplayName("숫자 리스트를 정확한 볼 리스트로 변환하는지 확인")
    @Test
    void convert_WithValidInput() {
        List<Integer> input = List.of(1, 2, 3);
        List<Ball> expected = List.of(
                Ball.valueOf(0, 1),
                Ball.valueOf(1, 2),
                Ball.valueOf(2, 3)
        );

        assertThat(BallConverter.convert(input))
                .isEqualTo(expected);
    }
}