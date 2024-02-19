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
  public Model model1, model2;

  public RendererTest(Vector2 dimensions, Camera camera) {
    super(dimensions, camera);
    String classPath = getClass().getResource("").getPath();
    triangles = new Triangles();
    model1 = LoadModel.loadModel(new File(classPath + "/tank.model"), Color.white, camera.renderer, camera);
    model2 = LoadModel.loadModel(new File(classPath + "/tank.model"), Color.red, camera.renderer, camera);
    model1.scale(0.2);
    model2.scale(0.2);
    model1.rotate(2, 0.5*3.14159265);
    model1.init(triangles);
    model2.init(triangles);
  }

  public void render(Graphics2D graphics) {
    triangles.render(graphics);
  }
}
