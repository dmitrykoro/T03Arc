import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Main extends JPanel implements ActionListener{

    URL url = getClass().getResource("Background.jpg");
    Image img = new ImageIcon(url).getImage();

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
        int blockShift = (blockWidth + Constants.DELAY_BTW_BLOCKS()) / 2;
        int addition = 0;
        boolean weNeedShift = true;

        paintSmth(g);
        //draw blocks
        int currentBlockNumber = 0;
        for (int i = Constants.LEFT_OVERLAY() + Constants.DELAY_BTW_BLOCKS();
             i < blocks.getV() * (blockWidth + Constants.DELAY_BTW_BLOCKS());
             i += (blockWidth + Constants.DELAY_BTW_BLOCKS())) {

            for (int j = Constants.LEFT_OVERLAY() + Constants.DELAY_BTW_BLOCKS() + addition;
                 j < Constants.RIGHT_OVERLAY() - Constants.DELAY_BTW_BLOCKS() - addition;
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

            if (weNeedShift) {
                weNeedShift = false;
                addition = blockShift;
            }
            else {
                weNeedShift = true;
                addition = 0;
            }
        }
    }

    public void paintSmth(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(100, 100, 500, 500);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        plank.move();
        ball.move(plank, false, 0, 0, 0);
    }
}
