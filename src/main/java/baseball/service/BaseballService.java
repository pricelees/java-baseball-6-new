package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.GameResult;
import baseball.domain.PitchResult;
import baseball.dto.BaseballDTO.BaseballRequest;
import baseball.dto.BaseballDTO.BaseballResponse;
import java.util.List;

public class BaseballService {
    public Balls createComputerBalls(BaseballRequest baseballRequest) {
        return Balls.valueOf(baseballRequest.computerNumbers());
    }

    public Balls createUserBalls(BaseballRequest baseballRequest) {
        return Balls.valueOf(baseballRequest.userNumbers());
    }

    public BaseballResponse compareAllBalls(Balls computerBalls, Balls userBalls) {
        GameResult gameResult = new GameResult();
        List<Ball> computers = computerBalls.balls();
        List<Ball> users = userBalls.balls();

        computers.stream()
                .flatMap(computerball -> users.stream().map(computerball::compare))
                .filter(PitchResult::isStrikeOrBall)
                .forEach(gameResult::update);

        return new BaseballResponse(gameResult.getStrikeCount(), gameResult.getBallCount());
    }
}

