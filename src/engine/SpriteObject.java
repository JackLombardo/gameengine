package engine;

import java.awt.*;

public class SpriteObject extends GameObject {
    public SpriteObject(int x, int y, String placeholder) {
        super(x, y, 50, 50);
    }

    @Override
    public void update() {
        // Update logic (if needed)
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);  // Draw a blue square
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}
