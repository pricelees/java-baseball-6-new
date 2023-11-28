package baseball.domain;

public enum PitchResult {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isBall() {
        return this.equals(BALL);
    }

    public boolean isStrikeOrBall() {
        return isStrike() || isBall();
    }
}
