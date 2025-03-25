package editor;

import engine.Scene;
import engine.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceneEditor extends JPanel {
    private Scene scene;
    private GameObject selectedObject;
    private int offsetX, offsetY;

    public SceneEditor(Scene scene) {
        this.scene = scene;
        setPreferredSize(new Dimension(800, 600));

        // Mouse controls for dragging objects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (GameObject obj : scene.getObjects()) {
                    if (e.getX() >= obj.getX() && e.getX() <= obj.getX() + obj.getWidth() &&
                        e.getY() >= obj.getY() && e.getY() <= obj.getY() + obj.getHeight()) {
                        selectedObject = obj;
                        offsetX = e.getX() - obj.getX();
                        offsetY = e.getY() - obj.getY();
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedObject = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedObject != null) {
                    int snappedX = ((e.getX() - offsetX) / 50) * 50;
                    int snappedY = ((e.getY() - offsetY) / 50) * 50;
                    selectedObject.setX(snappedX);
                    selectedObject.setY(snappedY);
                    repaint();
                }
            }
        });

    }
   
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid lines
        g.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < getWidth(); x += 50) {
            g.drawLine(x, 0, x, getHeight());
        }
        for (int y = 0; y < getHeight(); y += 50) {
            g.drawLine(0, y, getWidth(), y);
        }

        // Render objects
        scene.render(g);
    }

    
}
