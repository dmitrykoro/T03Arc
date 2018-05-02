

public class Ball {

    private int x = Constants.WINDOW_WIDTH() / 2;
    private int y = Constants.WINDOW_HEIGHT() - 100;

    enum Direction {UP_L, UP_R, DWN_L, DWN_R}
    private Direction ballDirection = Direction.UP_R;


    public void move(Plank plank) {
        while (true) {

            //we're hitting the right corner
            if (x + Constants.BALL_RADIUS() >= Constants.RIGHT_OVERLAY() &&
                    ballDirection == Direction.UP_R) {
                ballDirection = Direction.UP_L;
                break;
            }
            else if (x + Constants.BALL_RADIUS() >= Constants.RIGHT_OVERLAY() &&
                    ballDirection == Direction.DWN_R) {
                ballDirection = Direction.DWN_L;
                break;
            }

            //we're hitting the upper corner
            if (y <= Constants.UPPER_OVERLAY() &&
                    ballDirection == Direction.UP_R) {
                ballDirection = Direction.DWN_R;
                break;
            } else if (y <= Constants.UPPER_OVERLAY() &&
                    ballDirection == Direction.UP_L) {
                ballDirection = Direction.DWN_L;
                break;
            }

            //we're hitting the left corner
            if (x <= Constants.LEFT_OVERLAY() &&
                    ballDirection == Direction.DWN_L) {
                ballDirection = Direction.DWN_R;
                break;
            } else if (x <= Constants.LEFT_OVERLAY() &&
                    ballDirection == Direction.UP_L) {
                ballDirection = Direction.UP_R;
                break;
            }

            //we're hitting the plank
            if (y + Constants.BALL_RADIUS() >= Constants.WINDOW_HEIGHT() - 100 &&
                    y + Constants.BALL_RADIUS() <= Constants.WINDOW_HEIGHT() - 100 + Constants.PLANK_HEIGHT() &&
                    x >= plank.getX() - Constants.BALL_RADIUS() / 2 &&
                    x <= plank.getX() + Constants.PLANK_WIDTH() + Constants.BALL_RADIUS() / 2 &&
                    ballDirection == Direction.DWN_R) {
                ballDirection = Direction.UP_R;
                break;
            }
            if (y + Constants.BALL_RADIUS() >= Constants.WINDOW_HEIGHT() - 100 &&
                    y + Constants.BALL_RADIUS() <= Constants.WINDOW_HEIGHT() - 100 + Constants.PLANK_HEIGHT() &&
                    x >= plank.getX() - Constants.BALL_RADIUS() / 2 &&
                    x <= plank.getX() + Constants.PLANK_WIDTH() + Constants.BALL_RADIUS() / 2 &&
                    ballDirection == Direction.DWN_L) {
                ballDirection = Direction.UP_L;
                break;
            }
            break;
        }

        switch (ballDirection) {
            case UP_R:
                x += Constants.BALL_SPEED();
                y -= Constants.BALL_SPEED();
                break;
            case UP_L:
                x -= Constants.BALL_SPEED();
                y -= Constants.BALL_SPEED();
                break;
            case DWN_L:
                x -= Constants.BALL_SPEED();
                y += Constants.BALL_SPEED();
                break;
            case DWN_R:
                x += Constants.BALL_SPEED();
                y += Constants.BALL_SPEED();
        }
    }

   /* public void identifyDirection() {
        if(x >= Constants.WINDOW_WIDTH() - Constants.BALL_RADIUS() / 2) {
            ballDirection = Direction.UP_L;
        }
        if(y <= Constants.BALL_RADIUS() / 2) {
            ballDirection = Direction.DWN_L;
        }
    }*/

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
