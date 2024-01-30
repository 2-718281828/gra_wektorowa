package main;

import maths.Vector2;
import renderer.*;

import java.awt.*;
import java.io.File;

/**
 * Tymczasowa klasa mająca na celu testowanie renderowania
 *
 * @author Bartosz Węgrzyn
 */
public class RendererTest extends Renderer {

  public Triangles triangles;
  public Model model;

  public RendererTest(Vector2 dimensions, Camera camera) {
    super(dimensions, camera);
    String classPath = getClass().getResource("").getPath();
    triangles = new Triangles();
    model = LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.white, camera.renderer, camera);
    model.init(triangles);
  }

  public void render(Graphics2D graphics) {
    triangles.render(graphics);
  }
}
