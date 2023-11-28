package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import baseball.domain.Balls;
import baseball.dto.BaseballDTO.BaseballResponse;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballServiceTest {
    private static final BaseballService baseballService = new BaseballService();
    private static final Balls computerBalls = Balls.valueOf(List.of(1, 2, 3));
    @DisplayName("두 공을 받아 정확히 비교하는지 확인")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideArguments")
    void compareAllBalls(String testName, Balls userBalls, BaseballResponse expectedResult) {
        assertThat(baseballService.compareAllBalls(computerBalls, userBalls))
                .isEqualTo(expectedResult);
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments("3스트라이크", Balls.valueOf(List.of(1, 2, 3)), new BaseballResponse(3, 0)),
                arguments("2스트라이크", Balls.valueOf(List.of(1, 2, 4)), new BaseballResponse(2, 0)),
                arguments("1스트라이크", Balls.valueOf(List.of(1, 4, 5)), new BaseballResponse(1, 0)),
                arguments("3볼", Balls.valueOf(List.of(3, 1, 2)), new BaseballResponse(0, 3)),
                arguments("2볼", Balls.valueOf(List.of(6, 1, 2)), new BaseballResponse(0, 2)),
                arguments("1볼", Balls.valueOf(List.of(6, 7, 2)), new BaseballResponse(0, 1)),
                arguments("2볼 1스트라이크", Balls.valueOf(List.of(1, 3, 2)), new BaseballResponse(1, 2)),
                arguments("1볼 1스트라이크", Balls.valueOf(List.of(1, 3, 8)), new BaseballResponse(1, 1)),
                arguments("낫싱", Balls.valueOf(List.of(7, 8, 9)), new BaseballResponse(0, 0))
        );
    }
}