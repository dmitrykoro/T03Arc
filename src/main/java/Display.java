import javax.swing.*;

public class Display {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arcanoid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}
