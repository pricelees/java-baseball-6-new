package baseball.domain;

public record Ball(BallLocation location, BallNumber number) {
    public static Ball valueOf(int location, int number) {
        return new Ball(new BallLocation(location), new BallNumber(number));
    }

    public PitchResult compare(Ball other) {
        if (isStrike(other)) {
            return PitchResult.STRIKE;
        }
        if (isBall(other)) {
            return PitchResult.BALL;
        }
        return PitchResult.NOTHING;
    }

    private boolean isStrike(Ball other) {
        return this.equals(other);
    }

    private boolean isBall(Ball other) {
        return number.equals(other.number())
                && !location.equals(other.location());
    }
}
