package baseball.domain;

public class GameResult {
    private int strikeCount;
    private int ballCount;

    public GameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void update(PitchResult pitchResult) {
        if (pitchResult.isStrike()) {
            strikeCount++;
        }
        if (pitchResult.isBall()) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
