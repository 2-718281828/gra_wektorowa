package main;

import engine.Logic;
import renderer.Camera;

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
  }
}
