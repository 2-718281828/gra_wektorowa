package main;

import maths.Vector2;
import maths.Vector3;
import renderer.Renderer;
import renderer.Triangle;

import java.awt.*;

/**
 * Tymczasowa klasa mająca na celu testowanie renderowania
 *
 * @author Bartosz Węgrzyn
 */
public class RendererTest extends Renderer {

    Triangle triangle;

    public RendererTest(Vector2 dimensions) {
        super(dimensions);
        Vector3 verticies[] = new Vector3[]{new Vector3(-0.5f, 0.5f, 0),
                new Vector3(0, -0.5f, 0), new Vector3(0.5f, 0.5f, 0)};
        triangle = new Triangle(verticies, this);
    }

    public void render(Graphics2D graphics) {
        triangle.render(graphics);
    }
}
