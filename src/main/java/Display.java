import javax.swing.*;

public class Display {

    static Constants cnst = new Constants();

    public static void main(String[] args) {
        if (cnst.initialSettings() == -1) {
            System.exit(-1);
        }
        JFrame frame = new JFrame("Arcanoid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}
