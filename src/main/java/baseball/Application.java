package baseball;

import baseball.config.Configuration;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = Configuration.baseballController();
        baseballController.run();
    }
}
