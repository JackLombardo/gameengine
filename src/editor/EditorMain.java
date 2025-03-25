package editor;

import engine.Scene;
import engine.SceneLoader;
import engine.SpriteObject;

import javax.swing.*;
import java.awt.*;

public class EditorMain {
    private static SceneEditor editorPanel;
    private static Scene scene;

    public static void main(String[] args) {
        // Create window
        JFrame frame = new JFrame("Game Editor");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Initialize Scene
        scene = new Scene();
        editorPanel = new SceneEditor(scene);

        // Toolbar panel
        JPanel toolbar = new JPanel();
        JButton addObjectButton = new JButton("Add Object");
        JButton removeObjectButton = new JButton("Remove Object");
        JButton saveButton = new JButton("Save Scene");
        JButton loadButton = new JButton("Load Scene");

        // Button actions
        addObjectButton.addActionListener(e -> {
            scene.addObject(new SpriteObject(100, 100, "Placeholder"));
            editorPanel.repaint();
        });

        removeObjectButton.addActionListener(e -> {
            scene.removeLastObject();
            editorPanel.repaint();
        });

        saveButton.addActionListener(e -> SceneLoader.saveScene(scene, "level1.scene"));
        loadButton.addActionListener(e -> {
            Scene loadedScene = SceneLoader.loadScene("level1.scene");
            scene.load(loadedScene);
            editorPanel.repaint();
        });

        // Add buttons to toolbar
        toolbar.add(addObjectButton);
        toolbar.add(removeObjectButton);
        toolbar.add(saveButton);
        toolbar.add(loadButton);

        // Add components to frame
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(editorPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
