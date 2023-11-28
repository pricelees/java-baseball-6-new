package baseball.view.input;

import baseball.view.input.InputValidator.NumberValidator;
import baseball.view.input.InputValidator.StatusValidator;
import java.util.Arrays;
import java.util.List;

public class BaseballInputView {
    private static final String NUMBER_QUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_QUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NUMBER_DELIMITER = "";
    private final Reader reader;

    public BaseballInputView(Reader reader) {
        this.reader = reader;
    }

    public List<Integer> provideNumbers() {
        List<Integer> numbers = Arrays.stream(receiveNumbers().split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();

        NumberValidator.validateNumbers(numbers);
        return numbers;
    }

    private String receiveNumbers() {
        System.out.print(NUMBER_QUEST_MESSAGE);
        String input = reader.readLine();
        NumberValidator.validateFormat(input);

        return input;
    }

    public int provideStatus() {
        System.out.println(RESTART_QUEST_MESSAGE);
        String input = reader.readLine();
        StatusValidator.validate(input);

        return Integer.parseInt(input);
    }
}
