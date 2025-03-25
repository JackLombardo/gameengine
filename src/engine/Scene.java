package engine;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scene implements Serializable {
    private List<GameObject> objects = new ArrayList<>();

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public void removeLastObject() {
        if (!objects.isEmpty()) {
            objects.remove(objects.size() - 1);
        }
    }

    public void load(Scene otherScene) {
        this.objects = otherScene.getObjects();
    }

    public void update() {
        for (GameObject obj : objects) {
            obj.update();
        }
    }

    public void render(Graphics g) {
        for (GameObject obj : objects) {
            obj.render(g);
        }
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}
