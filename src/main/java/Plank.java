import java.awt.event.KeyEvent;

public class Plank {

    private int x = 400, speed = 8;

    enum Direction {LEFT, RIGHT, NONE}

    private Direction plankDirection = Direction.NONE;

    public void move() {
        switch(plankDirection) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case NONE:
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == 65 || key == 37) {
            plankDirection = Direction.LEFT;
        }
        else if(key == 68 || key == 39) {
            plankDirection = Direction.RIGHT;
        }
        else {
            plankDirection = Direction.NONE;
        }
    }

    public void keyReleased(KeyEvent e) {
        plankDirection = Direction.NONE;
    }

    public int getX() {
        return x;
    }

    public int getSpeed() {
        return speed;
    }
}
