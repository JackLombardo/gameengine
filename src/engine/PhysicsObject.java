package engine;

import java.awt.*;

public class PhysicsObject extends GameObject {
    private SpriteRenderer sprite;

    public PhysicsObject(int x, int y, String spritePath) {
        super(x, y, 32, 32);
        sprite = new SpriteRenderer(spritePath);
    }

    @Override
    public void update() {
        Physics.applyGravity(this);
    }

    @Override
    public void render(Graphics g) {
        sprite.render(g, x, y);
    }
}
