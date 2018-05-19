import java.awt.event.KeyEvent;

public class Global {

    enum GAME_STATUS {notStarted, running, pause, failed, restarted}

    private GAME_STATUS status = GAME_STATUS.running;

    private boolean weAreInPause = false;

    public Enum getStatus() {
        return status;
    }

    public void checkKey(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            if (weAreInPause) {
                status = GAME_STATUS.running;
                weAreInPause = false;
            }
            else {
                status = GAME_STATUS.pause;
                weAreInPause = true;
            }
        }
    }

}
