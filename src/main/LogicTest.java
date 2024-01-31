package main;

import engine.Logic;
import renderer.Camera;
import util.Console;
import maths.*;
import entity.*;
import renderer.*;

/**
 * Tymczasowa klasa do testowania logiki
 * 
 * @author Bartosz Węgrzyn
 */
public class LogicTest implements Logic {

  RendererTest renderer;
  Camera camera;
  EntityHandler entityHandler;
  TestEntity entity;

  public LogicTest(RendererTest renderer, Camera camera) {
    this.renderer = renderer;
    this.camera = camera;
    entityHandler = new EntityHandler();
    entityHandler.entities.add(new TestEntity(renderer.model1, new Vector3(0, 0, 0), entityHandler));
    entityHandler.entities.add(new TestEntity(renderer.model2, new Vector3(1, 1, -1), entityHandler));
  }

  public void update() {
    camera.update();
    entityHandler.logic();
  }
}

class TestEntity extends Entity {

  public TestEntity(Model model, Vector3 position, EntityHandler entityHandler) {
    super(model, position, entityHandler);
  }

  public void logic() {
    for (int i = 0; i < entityHandler.entities.size(); i++) {
      if (entityHandler.entities.get(i) != this) {
        if (collision(entityHandler.entities.get(i).hitbox))
          Console.log("collision");
      }
    }
  }
}
