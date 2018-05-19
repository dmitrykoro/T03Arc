

public class Ball {

    private int x = Constants.WINDOW_WIDTH() / 2;
    private int y = Constants.WINDOW_HEIGHT() - 100;

    enum Direction {UP_L, UP_R, DWN_L, DWN_R}

    private Direction ballDirection = Direction.UP_R;

    public void move(Plank plank, Boolean hittedBlock, int blockX, int blockY, int blockWidth) {
        if (!hittedBlock) {

            if (x + Constants.BALL_RADIUS() >= Constants.RIGHT_OVERLAY() &&
                    ballDirection == Direction.UP_R) {
                ballDirection = Direction.UP_L;
            } else if (x + Constants.BALL_RADIUS() >= Constants.RIGHT_OVERLAY() &&
                    ballDirection == Direction.DWN_R) {
                ballDirection = Direction.DWN_L;
            }

            //we're hitting the upper corner
            if (y <= Constants.UPPER_OVERLAY() &&
                    ballDirection == Direction.UP_R) {
                ballDirection = Direction.DWN_R;
            } else if (y <= Constants.UPPER_OVERLAY() &&
                    ballDirection == Direction.UP_L) {
                ballDirection = Direction.DWN_L;
            }

            //we're hitting the left corner
            if (x <= Constants.LEFT_OVERLAY() &&
                    ballDirection == Direction.DWN_L) {
                ballDirection = Direction.DWN_R;
            } else if (x <= Constants.LEFT_OVERLAY() &&
                    ballDirection == Direction.UP_L) {
                ballDirection = Direction.UP_R;
            }

            //if we want to reflect from lower corner
            /*if (y + Constants.BALL_RADIUS() >= Constants.LOWER_OVERLAY() &&
                    ballDirection == Direction.DWN_L) {
                ballDirection = Direction.UP_L;
            } else if (y + Constants.BALL_RADIUS() >= Constants.LOWER_OVERLAY() &&
                    ballDirection == Direction.DWN_R) {
                ballDirection = Direction.UP_R;
            }*/

            //we're hitting the plank
            if (y + Constants.BALL_RADIUS() >= plank.getY() &&
                    y + Constants.BALL_RADIUS() <= plank.getY() + Constants.PLANK_HEIGHT() &&
                    x >= plank.getX() - Constants.BALL_RADIUS() &&
                    x <= plank.getX() + Constants.PLANK_WIDTH() + Constants.BALL_RADIUS()) {
                if (ballDirection == Direction.DWN_R) {
                    ballDirection = Direction.UP_R;
                } else if (ballDirection == Direction.DWN_L) {
                    ballDirection = Direction.UP_L;
                }
            }
        } else {
            int centerX = x + Constants.BALL_RADIUS() / 2;
            int centerY = y + Constants.BALL_RADIUS() / 2;

            if (ballDirection == Direction.UP_R) {
                if ((centerX - blockX) * (-blockWidth) - (centerY - blockY - blockWidth) * blockWidth > 0) {
                    ballDirection = Direction.UP_L;
                } else {
                    ballDirection = Direction.DWN_R;
                }
            } else if (ballDirection == Direction.DWN_L) {
                if ((centerX - blockX) * (-blockWidth) - (centerY - blockY - blockWidth) * blockWidth > 0) {
                    ballDirection = Direction.UP_L;
                } else {
                    ballDirection = Direction.DWN_R;
                }
            } else if (ballDirection == Direction.UP_L) {
                if ((centerX - blockX) * blockWidth - (centerY - blockY) * blockWidth > 0) {
                    ballDirection = Direction.UP_R;
                } else {
                    ballDirection = Direction.DWN_L;
                }
            } else if (ballDirection == Direction.DWN_R) {
                if ((centerX - blockX) * blockWidth - (centerY - blockY) * blockWidth > 0) {
                    ballDirection = Direction.UP_R;
                } else {
                    ballDirection = Direction.DWN_L;
                }
            }
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

    public Boolean ballLose() {
            return y + Constants.BALL_RADIUS() >= Constants.LOWER_OVERLAY();
    }

    public void resetBallPosition() {
        x = Constants.WINDOW_WIDTH() / 2;
        y = Constants.WINDOW_HEIGHT() - 100;
        ballDirection = Direction.UP_R;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
