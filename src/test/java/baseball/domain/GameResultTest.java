package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultTest {

    @DisplayName("결과를 정확히 업데이트하는지 확인")
    @ParameterizedTest(name = "스트라이크 {1}개, 볼 {2}개 인 경우")
    @MethodSource("provideArguments")
    void update_3strike(List<PitchResult> inputResults, int expectedStrikeCount, int expectedBallCount) {
        GameResult gameResult = new GameResult();
        inputResults.forEach(gameResult::update);

        assertThat(gameResult.getStrikeCount() == expectedStrikeCount ||
                gameResult.getBallCount() == expectedBallCount)
                .isTrue();
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments(
                        List.of(PitchResult.STRIKE, PitchResult.STRIKE, PitchResult.STRIKE),
                        3,
                        0
                ),
                arguments(
                        List.of(PitchResult.STRIKE, PitchResult.STRIKE, PitchResult.NOTHING),
                        2,
                        0
                ),
                arguments(
                        List.of(PitchResult.STRIKE, PitchResult.NOTHING, PitchResult.NOTHING),
                        1,
                        0
                ),
                arguments(
                        List.of(PitchResult.STRIKE, PitchResult.BALL, PitchResult.BALL),
                        1,
                        2
                ),
                arguments(
                        List.of(PitchResult.STRIKE, PitchResult.BALL, PitchResult.NOTHING),
                        1,
                        1
                ),
                arguments(
                        List.of(PitchResult.BALL, PitchResult.BALL, PitchResult.BALL),
                        0,
                        3
                ),
                arguments(
                        List.of(PitchResult.BALL, PitchResult.BALL, PitchResult.NOTHING),
                        0,
                        2
                ),
                arguments(
                        List.of(PitchResult.BALL, PitchResult.NOTHING, PitchResult.NOTHING),
                        0,
                        1
                ),
                arguments(
                        List.of(PitchResult.NOTHING, PitchResult.NOTHING, PitchResult.NOTHING),
                        0,
                        0
                )
        );
    }
}