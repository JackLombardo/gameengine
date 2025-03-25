package engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteRenderer {
    private BufferedImage image;

    public SpriteRenderer(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Failed to load sprite: " + path);
        }
    }

    public void render(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
    }
}
