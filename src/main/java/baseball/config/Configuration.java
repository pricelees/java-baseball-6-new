package baseball.config;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.BaseballOutputView;
import baseball.view.input.BaseballInputView;
import baseball.view.input.Reader;

public class Configuration {
    public static BaseballController baseballController() {
        return new BaseballController(baseballService(), baseballInputView(), baseballOutputView());
    }

    private static BaseballService baseballService() {
        return new BaseballService();
    }

    private static BaseballInputView baseballInputView() {
        return new BaseballInputView(reader());
    }

    private static BaseballOutputView baseballOutputView() {
        return new BaseballOutputView();
    }

    private static Reader reader() {
        return new Reader();
    }
}
