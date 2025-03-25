package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
    private Timer timer;
    private Scene currentScene;

    public Game() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addKeyListener(new Input());
        setFocusable(true);
        requestFocus();

        currentScene = new Scene();
        timer = new Timer(16, this);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        currentScene.update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScene.render(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Game Engine");
        Game game = new Game();

        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
