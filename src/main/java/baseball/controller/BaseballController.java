package baseball.controller;

import baseball.constant.BaseballConstants;
import baseball.domain.Balls;
import baseball.dto.BaseballDTO.BaseballRequest;
import baseball.dto.BaseballDTO.BaseballResponse;
import baseball.service.BaseballService;
import baseball.util.RandomNumbersCreator;
import baseball.view.BaseballOutputView;
import baseball.view.input.BaseballInputView;
import java.util.List;

public class BaseballController {
    private final BaseballService baseballService;
    private final BaseballInputView baseballInputView;
    private final BaseballOutputView baseballOutputView;
    private List<Integer> computerNumbers;
    private GameStatus gameStatus;

    public BaseballController(BaseballService baseballService,
                              BaseballInputView baseballInputView,
                              BaseballOutputView baseballOutputView) {
        this.baseballService = baseballService;
        this.baseballInputView = baseballInputView;
        this.baseballOutputView = baseballOutputView;
    }

    public void run() {
        baseballOutputView.printWelcomeMessage();
        gameOn();
        loadComputerNumbers();
        play();
    }

    private void play() {
        while (GameStatus.isRunning(gameStatus)) {
            BaseballRequest baseballRequest = receiveUserNumber();

            Balls computerBalls = baseballService.createComputerBalls(baseballRequest);
            Balls userBalls = baseballService.createUserBalls(baseballRequest);

            BaseballResponse baseballResponse = baseballService.compareAllBalls(computerBalls, userBalls);
            baseballOutputView.printCompareResult(baseballResponse);
            processIfAllNumbersMatched(baseballResponse.strikeCount());
        }
    }

    private BaseballRequest receiveUserNumber() {
        List<Integer> userNumbers = baseballInputView.provideNumbers();

        return new BaseballRequest(computerNumbers, userNumbers);
    }

    private void processIfAllNumbersMatched(int strikeCount) {
        if (strikeCount == BaseballConstants.BALL_COUNT) {
            baseballOutputView.printGameEndMessage();
            questIfRestart();
        }
    }

    private void questIfRestart() {
        int statusCode = baseballInputView.provideStatus();
        if (GameStatus.isGameOnStatus(statusCode)) {
            loadComputerNumbers();
        }
        if (GameStatus.isGameOffStatus(statusCode)) {
            gameOff();
        }
    }

    private void gameOn() {
        gameStatus = GameStatus.GAME_ON;
    }

    private void gameOff() {
        gameStatus = GameStatus.GAME_OFF;
    }

    private void loadComputerNumbers() {
        computerNumbers = RandomNumbersCreator.create(BaseballConstants.BALL_COUNT);
    }
}
