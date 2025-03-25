package engine;

import java.io.*;
import java.util.List;

public class SceneLoader {
    public static void saveScene(Scene scene, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("scenes/" + filename))) {
            out.writeObject(scene.getObjects()); // Serialize objects
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Scene loadScene(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("scenes/" + filename))) {
            List<GameObject> objects = (List<GameObject>) in.readObject();
            Scene scene = new Scene();
            for (GameObject obj : objects) {
                scene.addObject(obj);
            }
            return scene;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Scene();
        }
    }
}
