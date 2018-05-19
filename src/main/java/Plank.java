import java.awt.event.KeyEvent;

public class Plank {

    private int x = Constants.WINDOW_WIDTH() / 2 - Constants.PLANK_WIDTH();
    private int y = Constants.WINDOW_HEIGHT() - 100;

    enum Direction {LEFT, RIGHT, NONE}

    private Direction plankDirection = Direction.NONE;

    public void move() {
        switch (plankDirection) {
            case LEFT:
                if (x >= Constants.LEFT_OVERLAY() + 3) {
                    x -= Constants.PLANK_SPEED();
                }
                break;
            case RIGHT:
                if (x + Constants.PLANK_WIDTH() + 6 <= Constants.RIGHT_OVERLAY()) {
                    x += Constants.PLANK_SPEED();
                }
                break;
            case NONE:
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 65 || key == 37) {
            plankDirection = Direction.LEFT;
        } else if (key == 68 || key == 39) {
            plankDirection = Direction.RIGHT;
        } else {
            plankDirection = Direction.NONE;
        }
        System.out.println(key);
    }

    public void keyReleased(KeyEvent e) {
        plankDirection = Direction.NONE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return Constants.PLANK_SPEED();
    }
}
