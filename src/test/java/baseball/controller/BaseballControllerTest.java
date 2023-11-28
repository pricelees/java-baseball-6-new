package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import baseball.config.Configuration;
import baseball.constant.BaseballConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class BaseballControllerTest {
    @DisplayName("게임을 재시작하며 가능한 모든 경우에 대해 테스트")
    @Test
    void run_forAllPossibleCase_WithRestart() {
        command(
                "312", "412", "918", "123", "1",
                "123", "516", "465", "456", "1",
                "781", "712", "789", "2"
        );
        String[] expectedResult = {
                "3볼", "2볼", "1볼", "3스트라이크",
                "낫싱", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크",
                "2스트라이크", "1스트라이크", "게임 종료"
        };
        assertExactResultTest(expectedResult, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @SafeVarargs
    private static <T> void assertExactResultTest(String[] expectedResult, final T value, final T... values) {
        try(final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(BaseballConstants.MIN_VALUE, BaseballConstants.MAX_VALUE))
                    .thenReturn(value, Arrays.stream(values).toArray());
            execute(expectedResult);
        }
    }

    private static void execute(String[] expectedResult) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BaseballController baseballController = Configuration.baseballController();
        baseballController.run();

        assertThat(out.toString()).contains(expectedResult);
    }
}