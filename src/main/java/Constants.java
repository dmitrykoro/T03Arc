import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Constants {

    private static String text;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = (int)screenSize.getWidth();
    private static int height = (int)screenSize.getHeight();


    /*public static final int WINDOW_WIDTH = width;
    public static final int WINDOW_HEIGHT = height;
    public static final int PLANK_SPEED = settings[0];
    public static final int PLANK_WIDTH = settings[1];
    public static final int PLANK_HEIGHT = 5;
    public static final int BALL_RADIUS = 15;
    public static final int BALL_SPEED = settings[2];
    public static final int RIGHT_OVERLAY = WINDOW_WIDTH - 35;
    public static final int LEFT_OVERLAY = 20;
    public static final int UPPER_OVERLAY = 20;
    public static final int LOWER_OVERLAY = WINDOW_HEIGHT - 55;
    public static final int NUM_OF_BLOCKS_H = settings[3];
    public static final int NUM_OF_BLOCKS_V = settings[4];
    public static final int DELAY_BTW_BLOCKS = settings[5];
    public static final int NUM_OF_LIVES = settings[6];*/

   private static int[] settings = new int[7];

    public int initialSettings() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("settings.ini"));
            String line;

            for (int i = 0; i < 7; i++) {
                try {
                    settings[i] = Integer.parseInt(br.readLine().substring(32));
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
            //System.out.println(Arrays.toString(settings));

        } catch (IOException e) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("settings.ini", "UTF-8");
            } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            if (writer == null) {
                return -1;
            }

            writer.println("Plank Speed.....................15");
            writer.println("Plank width.....................100");
            writer.println("Ball speed......................5");
            writer.println("Blocks by horizon...............15");
            writer.println("Blocks by vertical..............5");
            writer.println("Delay between blocks............40");
            writer.println("Lives...........................2");
            writer.close();
            e.printStackTrace();

            settings[0] = 15;
            settings[1] = 100;
            settings[2] = 5;
            settings[3] = 15;
            settings[4] = 5;
            settings[5] = 40;
            settings[6] = 2;
        }
        //System.out.println(settings[0]);
        return 1;
    }

    //int x = settings[0];



    public static final int WINDOW_WIDTH = width;
    public static final int WINDOW_HEIGHT = height;
    public static final int PLANK_HEIGHT = 5;
    public static final int BALL_RADIUS = 15;
    public static final int RIGHT_OVERLAY = WINDOW_WIDTH - 35;
    public static final int LEFT_OVERLAY = 20;
    public static final int UPPER_OVERLAY = 20;
    public static final int LOWER_OVERLAY = WINDOW_HEIGHT - 55;

    public static int PLANK_SPEED() {
        return settings[0];
    }

    public static int PLANK_WIDTH() {
        return settings[1];
    }

    public static int BALL_SPEED() {
        return settings[2];
    }

    public static int NUM_OF_BLOCKS_H() {
       return settings[3];
    }

    public static int NUM_OF_BLOCKS_V() {
        return settings[4];
    }

    public static int DELAY_BTW_BLOCKS() {
        return settings[5];
    }

    public static int NUM_OF_LIVES() {
        return settings[6];
    }

}
