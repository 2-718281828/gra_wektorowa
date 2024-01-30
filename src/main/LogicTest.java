package main;

import engine.Logic;
import renderer.Camera;
import maths.*;

/**
 * Tymczasowa klasa do testowania logiki
 * 
 * @author Bartosz Węgrzyn
 */
public class LogicTest implements Logic {

  RendererTest renderer;
  Camera camera;

  public LogicTest(RendererTest renderer, Camera camera) {
    this.renderer = renderer;
    this.camera = camera;
  }

  public void update() {
    camera.update();
    renderer.model.rotate(2, 0.05);
    renderer.model.move(new Vector3(0.05, 0.05, 0.05));
  }
}
