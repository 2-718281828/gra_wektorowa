package renderer;

import java.awt.*;
import java.util.ArrayList;

import maths.*;

/**
 * Model 3D
 * 
 * @author Bartosz Węgrzyn
 */
public class Model {
  public ArrayList<Triangle> triangles = new ArrayList<>();
  public Color color;
  public Vector3 rotationAxis;

  /**
   * Tworzy nowy obiekt model
   * 
   * @param triangles lista trójkątów
   * @param color     kolor modelu (jeden kolor na model)
   * @author Bartosz Węgrzyn
   */
  public Model(ArrayList<Triangle> triangles, Color color) {
    this.triangles = triangles;
    this.color = color;
    updateVerticies();
  }

  public void updateVerticies() {
    double avgX = 0, avgY = 0, avgZ = 0;
    for (int i = 0; i < triangles.size(); i++) {
      for (int j = 0; j < 3; j++) {
        avgX += triangles.get(i).verticies[j].x;
        avgY += triangles.get(i).verticies[j].y;
        avgZ += triangles.get(i).verticies[j].z;

      }

    }
    avgX /= (3 * triangles.size());
    avgY /= (3 * triangles.size());
    avgZ /= (3 * triangles.size());
    rotationAxis = new Vector3(avgX, avgY, avgZ);
  }

  /**
   * Dodaje wszystkie trójkąty tego modelu do innej listy trójkątów
   *
   * @param triangles lista trójkątów
   * @author Bartosz Węgrzyn
   */
  public void init(Triangles triangles) {
    for (int i = 0; i < this.triangles.size(); i++) {
      this.triangles.get(i).color = this.color;
      triangles.triangles.add(this.triangles.get(i));
    }
  }

  /**
   * Obraca model wokół własnej osi.
   * 
   * @param axis  0 - oś x, 1 - oś y, 2 - oś z
   * @param angle kąt obrotu
   * @author Bartosz Węgrzyn
   */
  public void rotate(int axis, double angle) {
    for (int i = 0; i < triangles.size(); i++) {
      if (axis == 0) {
        triangles.get(i).rotatePitch(angle, false, rotationAxis);
      } else if (axis == 1) {
        triangles.get(i).rotateYaw(angle, false, rotationAxis);
      } else if (axis == 2) {
        triangles.get(i).rotateRoll(angle, false, rotationAxis);
      }
    }
  }

  /**
   * Przesuwa model o dany wektor.
   * 
   * @param displacement wektor przesunięcia
   * @author Bartosz Węgrzyn
   */
  public void move(Vector3 displacement) {
    for (int i = 0; i < triangles.size(); i++) {
      for (int j = 0; j < 3; j++) {
        triangles.get(i).verticies[j].add(displacement);
      }
    }
    updateVerticies();
  }
}
