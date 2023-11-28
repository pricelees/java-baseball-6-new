package baseball.domain;

import baseball.constant.BaseballConstants;

public record BallLocation(int location) {
    private static final String LOCATION_ERROR = "[ERROR] 공의 위치 범위를 초과했습니다.";
    public BallLocation {
        validate(location);
    }

    private void validate(int location) {
        if (location >= BaseballConstants.BALL_COUNT || location < BaseballConstants.ZERO) {
            throw new IllegalArgumentException(LOCATION_ERROR);
        }
    }
}
