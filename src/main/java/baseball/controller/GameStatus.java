package baseball.controller;

public enum GameStatus {
    GAME_ON(1),
    GAME_OFF(2);

    private final int statusCode;

    GameStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public static boolean isRunning(GameStatus gameStatus) {
        return gameStatus == GAME_ON;
    }

    public static boolean isGameOnStatus(int status) {
        return status == GAME_ON.statusCode;
    }

    public static boolean isGameOffStatus(int status) {
        return status == GAME_OFF.statusCode;
    }
}
