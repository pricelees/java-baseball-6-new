package baseball.dto;

import java.util.List;

public class BaseballDTO {
    public record BaseballRequest(List<Integer> computerNumbers, List<Integer> userNumbers) {
    }

    public record BaseballResponse(int strikeCount, int ballCount) {
    }
}
