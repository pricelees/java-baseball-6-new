package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import baseball.constant.BaseballConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RandomNumbersCreatorTest {
    @DisplayName("중복되지 않는 3개의 숫자를 반환하는지 확인")
    @Test
    void create() {
        // Randoms.pickNumberInRange가 중복된 숫자를 반환하도록 설정하고,
        // RandomNumbersCreator가 이 중복된 숫자를 필터링하는지 확인

        setRandomNumber(1, 2, 1, 1, 2, 2, 1, 1, 3);
        assertThat(RandomNumbersCreator.create(3)).isEqualTo(List.of(1, 2, 3));
    }

    @SafeVarargs
    private static <T> void setRandomNumber(final T value, final T... values) {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(BaseballConstants.MIN_VALUE, BaseballConstants.MAX_VALUE))
                .thenReturn(value, values);
    }
}