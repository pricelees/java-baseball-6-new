package baseball.view.input;

import baseball.constant.BaseballConstants;
import java.util.LinkedHashSet;
import java.util.List;

public class InputValidator {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static class NumberValidator {
        private static final String ONLY_NUMBER_REGEX = "[0-9]+";
        public static void validateFormat(String numbers) {
            if (isInvalidFormat(numbers)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_NUMBER);
            }
        }

        private static boolean isInvalidFormat(String numbers) {
            return !numbers.matches(ONLY_NUMBER_REGEX);
        }

        public static void validateNumbers(List<Integer> numbers) {
            if (isInvalidCount(numbers)) {
                throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_COUNT);
            }
            if (hasDuplicateNumber(numbers)) {
                throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.DUPLICATE_NUMBER);
            }
            if (hasInvalidRange(numbers)) {
                throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_RANGE);
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

        private interface ErrorMessage {
            String NOT_ONLY_NUMBER = "입력은 숫자만 가능합니다.";
            String INVALID_COUNT = "공의 갯수는 3개만 가능합니다.";
            String DUPLICATE_NUMBER = "중복된 숫자는 불가능합니다.";
            String INVALID_RANGE = "숫자는 1부터 9까지만 가능합니다.";
        }
    }

    public static class StatusValidator {
        private static final String RESTART = "1";
        private static final String END = "2";

        public static void validate(String status) {
            if (status.equals(RESTART) || status.equals(END)) {
                return;
            }
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_STATUS_CODE);
        }

        private interface ErrorMessage {
            String INVALID_STATUS_CODE = "유효하지 않은 입력입니다.";
        }
    }
}
