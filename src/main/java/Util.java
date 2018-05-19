import java.awt.*;

public class Util {

    //feature that calculates the x pos of text, if we want text in center
    public int getXforTextInCenter(String text, Font font, Graphics g) {
        FontMetrics size = g.getFontMetrics(font);
        return (Constants.WINDOW_WIDTH - size.stringWidth(text)) / 2;
    }

}
