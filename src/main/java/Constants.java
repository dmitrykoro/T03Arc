import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Constants {

    private static String text;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = (int)screenSize.getWidth();
    private static int height = (int)screenSize.getHeight();


    public static final int WINDOW_WIDTH = width;
    public static final int WINDOW_HEIGHT = height;
    public static final int PLANK_SPEED = 15;
    public static final int PLANK_WIDTH = 100;
    public static final int PLANK_HEIGHT = 5;
    public static final int BALL_RADIUS = 15;
    public static final int BALL_SPEED = 5;
    public static final int RIGHT_OVERLAY = WINDOW_WIDTH - 35;
    public static final int LEFT_OVERLAY = 20;
    public static final int UPPER_OVERLAY = 20;
    public static final int LOWER_OVERLAY = WINDOW_HEIGHT - 55;
    public static final int NUM_OF_BLOCKS_H = 25;
    public static final int NUM_OF_BLOCKS_V = 8;
    public static final int DELAY_BTW_BLOCKS = 40;
    public static final int NUM_OF_LIVES = 2;

    public void initialSettings() {

        try {
            text = new String(Files.readAllBytes(Paths.get("settings.ini")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("settings.ini", "UTF-8");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            writer.println("Window width.................1280");
            writer.println("Window Height.................800");
            writer.println("Plank Speed....................15");
            writer.println("Plank width...................100");
            writer.println("Ball speed......................5");
            writer.println("Blocks by horizon..............15");
            writer.println("Blocks by vertical..............5");
            writer.println("Lives...........................2");
            writer.close();
            e.printStackTrace();
        }

    }

}
