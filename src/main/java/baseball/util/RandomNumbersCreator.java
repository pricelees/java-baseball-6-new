package baseball.util;

import baseball.constant.BaseballConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersCreator {
    public static List<Integer> create(int ballCount) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < ballCount) {
            int randomNumber = Randoms.pickNumberInRange(BaseballConstants.MIN_VALUE, BaseballConstants.MAX_VALUE);
            numbers.add(randomNumber);
        }

        return new ArrayList<>(numbers);
    }
}
