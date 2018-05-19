import java.awt.event.KeyEvent;

public class Global {

    enum GAME_STATUS {notStarted, running, pause, failed, restarted}

    private GAME_STATUS status = GAME_STATUS.notStarted;

    private boolean weAreInPause = false;

    private int score = 0;

    private int lives = Constants.NUM_OF_LIVES;

    public Enum getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score += 10;
    }

    public void resetScore() {
        score = 0;
    }

    public int getLives() {
        return lives;
    }

    public void decreaseLives() {
        lives -= 1;
    }

    public void resetLives() {
        lives = Constants.NUM_OF_LIVES;
    }

    public void checkKey(KeyEvent e) {
        if (e.getKeyCode() == 27 && status != GAME_STATUS.failed) {
            if (weAreInPause) {
                status = GAME_STATUS.running;
                weAreInPause = false;
            } else {
                status = GAME_STATUS.pause;
                weAreInPause = true;
            }
        }
        if (e.getKeyCode() == 82 && status == GAME_STATUS.failed) {
            resetScore();
            status = GAME_STATUS.running;
        }
        if (e.getKeyCode() == 10 && status == GAME_STATUS.notStarted) {
            status = GAME_STATUS.running;
        }
    }

    public void setStatusFailed() {
        status = GAME_STATUS.failed;
    }

}
