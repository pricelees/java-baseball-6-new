package baseball.domain;

import baseball.constant.BaseballConstants;

public record BallNumber(int number) {
    private static final String VALUE_ERROR = "[ERROR] 숫자 범위를 초과했습니다.";
    public BallNumber {
        validate(number);
    }

    private void validate(int number) {
        if (number < BaseballConstants.MIN_VALUE || number > BaseballConstants.MAX_VALUE) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }
}