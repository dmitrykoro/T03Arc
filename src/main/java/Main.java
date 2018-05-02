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
        g.drawImage(img, 0,0, frame.getWidth(), frame.getHeight(), null);
        g.setColor(Color.WHITE);
        g.drawLine(20, 20, Constants.WINDOW_WIDTH() - 35, 20);
        g.drawLine(Constants.WINDOW_WIDTH() - 35, 20, Constants.WINDOW_WIDTH() - 35, Constants.WINDOW_HEIGHT() - 55);
        g.drawLine(Constants.WINDOW_WIDTH() - 35, Constants.WINDOW_HEIGHT() - 55, 20, Constants.WINDOW_HEIGHT() - 55);
        g.drawLine(20, Constants.WINDOW_HEIGHT() - 55, 20, 20);
        g.fillRect(plank.getX(), frame.getHeight() - 100, Constants.PLANK_WIDTH(), Constants.PLANK_HEIGHT());
        g.fillOval(ball.getX(), ball.getY(), Constants.BALL_RADIUS(), Constants.BALL_RADIUS());
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        plank.move();
        ball.move(plank);
    }
}
