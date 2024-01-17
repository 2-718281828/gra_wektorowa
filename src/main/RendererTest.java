package main;

import maths.Vector2;
import maths.Vector3;
import renderer.*;
import util.Console;

import java.awt.*;
import java.io.File;

/**
 * Tymczasowa klasa mająca na celu testowanie renderowania
 *
 * @author Bartosz Węgrzyn
 */
public class RendererTest extends Renderer {

    Triangles triangles;


    public RendererTest(Vector2 dimensions, Camera camera) {
        super(dimensions, camera);
        triangles = new Triangles();
        Model model = LoadModel.loadModel(new File("src/main/torus.model"), Color.white, camera.renderer, camera);
        for (int i = 0; i < model.triangles.size(); i++) {
            triangles.triangles.add(model.triangles.get(i));
        }
    }

    public void render(Graphics2D graphics) {
        triangles.render(graphics);
    }
}
