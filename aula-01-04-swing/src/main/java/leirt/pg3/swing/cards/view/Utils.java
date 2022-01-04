package leirt.pg3.swing.cards.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class Utils {

    public static Icon getIconFromResource(String iconRes, int width, int height)  {
        try {
            InputStream playImageStream =
                ClassLoader.getSystemResourceAsStream(iconRes);
            BufferedImage img = ImageIO.read(playImageStream);
            Image butImg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;

            ImageIcon icon =   new ImageIcon(butImg);
            return new ImageIcon( butImg );
        }
        catch(IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
