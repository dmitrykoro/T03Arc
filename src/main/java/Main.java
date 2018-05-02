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
        g.fillRect(plank.getX(), 500, 50, 5);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        plank.move();
    }
}
