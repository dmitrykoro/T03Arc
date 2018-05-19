import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Blocks {

    private int h = Constants.NUM_OF_BLOCKS_H();
    private int v = Constants.NUM_OF_BLOCKS_V();

    public Boolean isBallHitting(Ball ball, int blockX, int blockY, int blockWidth) {
        Rectangle2D currentBlock = new Rectangle(blockX, blockY, blockWidth, blockWidth);
        Rectangle2D round = new Rectangle(ball.getX(), ball.getY(), Constants.BALL_RADIUS(), Constants.BALL_RADIUS());
        if (currentBlock.intersects(round)) {

            return true;
        }
        return false;
    }

    public int getH() {
        return h;
    }

    public int getV() {
        return v;
    }
}
