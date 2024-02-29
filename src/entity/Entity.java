package entity;

import java.util.Arrays;

import maths.Matrix3x3;
import maths.Vector3;
import renderer.*;

/**
 * Ta klasa zawiera najważniejsze funkcje związane z obiektami w grze
 * 
 * @author Bartosz Węgrzyn
 */
public abstract class Entity {

  public Vector3 position, velocity;
  public double rotation;
  public Model model;
  public EntityHandler entityHandler;
  private double[] xs, ys, zs;
  /**
   * Współrzędne w 1 rzędzie tej macierzy przedstawiają najmniejsze współrzędne
   * ograniczające sześcian, a w 2 rzędzie największe. Współrzędne w 3 rzędzie są
   * równe 0.
   * 
   * @author Bartosz Węgrzyn
   */
  public Matrix3x3 hitbox;

  public Entity(Model model, Vector3 position, EntityHandler entityHandler) {
    this.model = model;
    this.position = position;
    this.entityHandler = entityHandler;
    velocity = new Vector3(0, 0, 0);
    rotation = 0;
    hitbox = new Matrix3x3(new double[3][3]);
    model.updateVerticies();
    Vector3 v3 = new Vector3(model.rotationAxis);
    v3.multiply(-1);
    model.move(v3);
    model.move(position);
    model.updateVerticies();
  }

  /**
   * Aktualizuje dane hitboxu.
   * Funkcja powinna być wywoływana za każdym razem, gdy pozycja obiektu zostanie
   * zmieniona.
   * 
   * @author Bartosz Węgrzyn
   */
  public void updateHitbox() {
    xs = new double[3 * model.triangles.size()];
    ys = new double[3 * model.triangles.size()];
    zs = new double[3 * model.triangles.size()];
    for (int i = 0; i < model.triangles.size(); i++) {
      for (int j = 0; j < 3; j++) {
        xs[3 * i + j] = model.triangles.get(i).verticies[j].x;
        ys[3 * i + j] = model.triangles.get(i).verticies[j].y;
        zs[3 * i + j] = model.triangles.get(i).verticies[j].z;
      }
    }
    Arrays.sort(xs);
    Arrays.sort(ys);
    Arrays.sort(zs);
    double[][] data = new double[3][3];
    data[0][0] = xs[0];
    data[0][1] = ys[0];
    data[0][2] = zs[0];
    data[1][0] = xs[3 * model.triangles.size() - 1];
    data[1][1] = ys[3 * model.triangles.size() - 1];
    data[1][2] = zs[3 * model.triangles.size() - 1];
    for (int i = 0; i < 3; i++) {
      data[2][i] = 0;
    }
    hitbox.data = data;
  }

  /**
   * Logika obiektu
   * 
   * @author Bartosz Węgrzyn
   */
  public abstract void logic();

  public boolean collision(Matrix3x3 hitbox) {
    updateHitbox();
    if (((this.hitbox.data[0][0] >= hitbox.data[0][0] && this.hitbox.data[0][0] <= hitbox.data[1][0])
        || (this.hitbox.data[1][0] >= hitbox.data[0][0] && this.hitbox.data[1][0] <= hitbox.data[1][0])) || ((hitbox.data[0][0] >= this.hitbox.data[0][0] && hitbox.data[0][0] <= this.hitbox.data[1][0])
        || (hitbox.data[1][0] >= this.hitbox.data[0][0] && hitbox.data[1][0] <= this.hitbox.data[1][0]))) {
      if (((this.hitbox.data[0][1] >= hitbox.data[0][1] && this.hitbox.data[0][1] <= hitbox.data[1][1])
        || (this.hitbox.data[1][1] >= hitbox.data[0][1] && this.hitbox.data[1][1] <= hitbox.data[1][1])) || ((hitbox.data[0][1] >= this.hitbox.data[0][1] && hitbox.data[0][1] <= this.hitbox.data[1][1])
        || (hitbox.data[1][1] >= this.hitbox.data[0][1] && hitbox.data[1][1] <= this.hitbox.data[1][1]))) {
        if (((this.hitbox.data[0][2] >= hitbox.data[0][2] && this.hitbox.data[0][2] <= hitbox.data[1][2])
        || (this.hitbox.data[1][2] >= hitbox.data[0][2] && this.hitbox.data[1][2] <= hitbox.data[1][2])) || ((hitbox.data[0][2] >= this.hitbox.data[0][2] && hitbox.data[0][2] <= this.hitbox.data[1][2])
        || (hitbox.data[1][2] >= this.hitbox.data[0][2] && hitbox.data[1][2] <= this.hitbox.data[1][2]))) {
          return true;
        }
      }
    }
    return false;
  }

}
