package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallTest {
    @DisplayName("두 공의 비교 결과가 정확한지 확인")
    @ParameterizedTest(name = "{2}")
    @MethodSource("provideArguments")
    void compare(Ball firstBall, Ball secondBall, PitchResult expectedResult) {
        assertThat(firstBall.compare(secondBall)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments(Ball.valueOf(0, 1), Ball.valueOf(0, 1), PitchResult.STRIKE),
                arguments(Ball.valueOf(0, 9), Ball.valueOf(2, 9), PitchResult.BALL),
                arguments(Ball.valueOf(0, 1), Ball.valueOf(1, 2), PitchResult.NOTHING)
        );
    }
}