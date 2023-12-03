package main;

import maths.Vector2;
import maths.Vector3;
import renderer.Camera;
import renderer.Renderer;
import renderer.Triangle;
import renderer.Triangles;

import java.awt.*;

/**
 * Tymczasowa klasa mająca na celu testowanie renderowania
 *
 * @author Bartosz Węgrzyn
 */
public class RendererTest extends Renderer {

    Triangles triangles;
    Camera camera;


    public RendererTest(Vector2 dimensions, Camera camera) {
        super(dimensions);
        this.camera = camera;
        triangles = new Triangles();
        Vector3 verticies[] = new Vector3[]{new Vector3(0, 0, 0),
                new Vector3(1, 0, 0), new Vector3(0, 1, 0)};
        triangles.triangles.add(new Triangle(verticies, this, camera));
        verticies = new Vector3[]{new Vector3(0, 1, 0),
                new Vector3(1, 1, 0), new Vector3(1, 0, 0)};
        triangles.triangles.add(new Triangle(verticies, this, camera));
        verticies = new Vector3[]{new Vector3(0, 0, 3),
                new Vector3(1, 0, 2), new Vector3(0, 1, 3)};
        Triangle t1 = new Triangle(verticies, this, camera);
        t1.color = Color.GREEN;
        triangles.triangles.add(t1);
        verticies = new Vector3[]{new Vector3(0, 1, 3),
                new Vector3(1, 1, 2), new Vector3(1, 0, 3)};
        Triangle t2 = new Triangle(verticies, this, camera);
        t2.color = Color.GREEN;
        triangles.triangles.add(t2);
    }

    public void render(Graphics2D graphics) {
        triangles.render(graphics);
    }
}
