package main;

import maths.Vector2;
import maths.Vector3;
import renderer.Camera;
import renderer.Renderer;
import renderer.Triangle;
import renderer.Triangles;
import util.Console;

import java.awt.*;

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
        Vector3[] vertices = new Vector3[]{
                new Vector3(0, 0, 0),
                new Vector3(1, 0, 0),
                new Vector3(1, 1, 0),
                new Vector3(0, 1, 0),
                new Vector3(0, 0, 1),
                new Vector3(1, 0, 1),
                new Vector3(1, 1, 1),
                new Vector3(0, 1, 1),
        };

        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[1], vertices[2]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[2], vertices[3]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[4], vertices[5], vertices[6]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[4], vertices[6], vertices[7]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[3], vertices[7]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[7], vertices[4]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[1], vertices[5], vertices[6]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[1], vertices[6], vertices[2]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[4], vertices[5]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[0], vertices[5], vertices[1]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[3], vertices[2], vertices[6]},
                camera.renderer, camera));
        triangles.triangles.add(new Triangle(new Vector3[]{vertices[3], vertices[6], vertices[7]},
                camera.renderer, camera));
    }

    public void render(Graphics2D graphics) {
        triangles.render(graphics);
    }
}
