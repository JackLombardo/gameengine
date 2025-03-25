package engine;

import java.awt.*;

public class Physics {
    public static boolean checkCollision(GameObject a, GameObject b) {
        Rectangle r1 = new Rectangle(a.x, a.y, a.width, a.height);
        Rectangle r2 = new Rectangle(b.x, b.y, b.width, b.height);
        return r1.intersects(r2);
    }

    public static void applyGravity(GameObject obj) {
        obj.y += 2; // Simple gravity effect
    }
}
