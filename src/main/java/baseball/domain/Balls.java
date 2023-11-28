package baseball.domain;

import baseball.constant.BaseballConstants;
import baseball.util.BallConverter;
import java.util.LinkedHashSet;
import java.util.List;

public record Balls(List<Ball> balls) {
    public static Balls valueOf(List<Integer> numbers) {
        validate(numbers);
        return new Balls(BallConverter.convert(numbers));
    }

    private static void validate(List<Integer> numbers) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.INVALID_COUNT);
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.DUPLICATE_NUMBER);
        }
        if (hasInvalidRange(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.INVALID_RANGE);
        }
    }

    private static boolean isInvalidCount(List<Integer> numbers) {
        return numbers.size() != BaseballConstants.BALL_COUNT;
    }

    private static boolean hasDuplicateNumber(List<Integer> numbers) {
        return new LinkedHashSet<>(numbers).size() != numbers.size();
    }

    private static boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > BaseballConstants.MAX_VALUE || number < BaseballConstants.MIN_VALUE);
    }

    private interface NumberErrorMessage {
        String INVALID_COUNT = "[ERROR] 공의 갯수는 3개만 가능합니다.";
        String DUPLICATE_NUMBER = "[ERROR] 중복된 숫자는 불가능합니다.";
        String INVALID_RANGE = "[ERROR] 숫자는 1부터 9까지만 가능합니다.";
    }
}
