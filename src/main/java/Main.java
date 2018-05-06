import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JPanel implements ActionListener{

    Image img = new ImageIcon("Background.jpg").getImage();

    Timer timer = new Timer(10, this);

    JFrame frame;

    Plank plank = new Plank();

    Ball ball = new Ball();

    Blocks blocks = new Blocks();

    boolean[] deadBlocks = new boolean[Constants.NUM_OF_BLOCKS_H() * Constants.NUM_OF_BLOCKS_V()];

    public Main(JFrame frame) {
        timer.start();
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                plank.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                plank.keyReleased(e);
            }
        });
        this.frame = frame;
    }

    public void paint(Graphics g) {

        g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.setColor(Color.WHITE);
        g.drawLine(20, 20, Constants.WINDOW_WIDTH() - 35, 20);
        g.drawLine(Constants.WINDOW_WIDTH() - 35, 20, Constants.WINDOW_WIDTH() - 35, Constants.WINDOW_HEIGHT());
        g.drawLine(20, Constants.WINDOW_HEIGHT(), 20, 20);
        g.fillRect(plank.getX(), plank.getY(), Constants.PLANK_WIDTH(), Constants.PLANK_HEIGHT());
        g.fillOval(ball.getX(), ball.getY(), Constants.BALL_RADIUS(), Constants.BALL_RADIUS());

        int blockWidth = (Constants.WINDOW_WIDTH() - Constants.LEFT_OVERLAY() - 30
                - (blocks.getH() + 1) * Constants.DELAY_BTW_BLOCKS()) / Constants.NUM_OF_BLOCKS_H();

        //draw blocks
        int currentBlockNumber = 0;
        for (int i = Constants.LEFT_OVERLAY() + Constants.DELAY_BTW_BLOCKS();
             i < blocks.getV() * (blockWidth + Constants.DELAY_BTW_BLOCKS());
             i += (blockWidth + Constants.DELAY_BTW_BLOCKS())) {
            for (int j = Constants.LEFT_OVERLAY() + Constants.DELAY_BTW_BLOCKS();
                 j < Constants.RIGHT_OVERLAY() - Constants.DELAY_BTW_BLOCKS();
                 j += (blockWidth + Constants.DELAY_BTW_BLOCKS())) {
                if (!deadBlocks[currentBlockNumber]) {
                    if (blocks.isBallHitting(ball, j, i, blockWidth)) {
                        deadBlocks[currentBlockNumber] = true;
                        ball.move(plank, true, j, i, blockWidth);
                    }
                    else {
                        g.fillRect(j, i, blockWidth, blockWidth);
                    }
                }
                currentBlockNumber++;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        plank.move();
        ball.move(plank, false, 0, 0, 0);
    }
}
