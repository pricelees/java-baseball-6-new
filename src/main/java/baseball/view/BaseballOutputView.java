package baseball.view;

import baseball.constant.BaseballConstants;
import baseball.dto.BaseballDTO.BaseballResponse;

public class BaseballOutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";
    private static final String GAME_END_MESSAGE = BaseballConstants.BALL_COUNT + "개를 모두 맞히셨습니다! 게임 종료";
    public void printWelcomeMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printCompareResult(final BaseballResponse baseballResponse) {
        final int strikeCount = baseballResponse.strikeCount();
        final int ballCount = baseballResponse.ballCount();

        if (strikeCount > BaseballConstants.ZERO && ballCount > BaseballConstants.ZERO) {
            System.out.println(ballCount + BALL + SPACE + strikeCount + STRIKE);
        }
        if (strikeCount > BaseballConstants.ZERO && ballCount == BaseballConstants.ZERO) {
            System.out.println(strikeCount + STRIKE);
        }
        if (strikeCount == BaseballConstants.ZERO && ballCount > BaseballConstants.ZERO) {
            System.out.println(ballCount + BALL);
        }
        if (strikeCount == BaseballConstants.ZERO && ballCount == BaseballConstants.ZERO) {
            System.out.println(NOTHING);
        }
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
