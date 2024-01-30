package entity;

import maths.Vector3;
import renderer.*;

public abstract class Entity {

  public Vector3 position, velocity;
  public double rotation;
  public Model model;

  public Entity(Model model, Vector3 position) {
    this.model = model;
    this.position = position;
    velocity = new Vector3(0, 0, 0);
    rotation = 0;
  }

  public abstract void logic();

}
