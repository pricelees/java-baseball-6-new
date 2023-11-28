package baseball.util;

import baseball.domain.Ball;
import java.util.List;
import java.util.stream.IntStream;

public class BallConverter {
    private static final int FIRST_BALL_LOCATION = 0;

    public static List<Ball> convert(List<Integer> numbers) {
        return IntStream.range(FIRST_BALL_LOCATION, numbers.size())
                .mapToObj(location -> Ball.valueOf(location, numbers.get(location)))
                .toList();
    }
}
