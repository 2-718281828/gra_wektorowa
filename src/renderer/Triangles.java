package renderer;

import util.Console;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Ta klasa zajmuje się zarządzaniem dużą ilością trójkątów
 *
 * @author Bartosz Węgrzyn
 */
public class Triangles {
  /**
   * Ta lista zawiera wszystkie obiekty triangle znajdujące się na scenie
   *
   * @author Bartosz Węgrzyn
   */
  public ArrayList<Triangle> triangles = new ArrayList<>();

  /**
   * Ta funkcja renderuje trójkąty - najpierw te najdalsze, na końcu te najbliższe
   *
   * @param graphics obiekt Graphics2D
   * @author Bartosz Węgrzyn
   */
  public void render(Graphics2D graphics) {
    sort();
    for (int i = triangles.size() - 1; i >= 0; i--) {
      triangles.get(i).render(graphics);
    }
  }

  /**
   * Ta funkcja aktualizuje wierzchołki trójkątów
   *
   * @author Bartosz Węgrzyn
   */
  public void update() {
    for (int i = triangles.size() - 1; i >= 0; i--) {
      triangles.get(i).updateVerticies();
    }
  }

  Comparator<Triangle> triangleComparator = new Comparator<Triangle>() {
    @Override
    public int compare(Triangle o1, Triangle o2) {
      return Double.valueOf(o1.avgDistance).compareTo(o2.avgDistance);
    }
  };

  /**
   * Ta funkcja sortuje trójkąty według ich wzrastającej odległości z od kamery
   *
   * @author Bartosz Węgrzyn
   */
  public void sort() {
    triangles.sort(triangleComparator);
  }
}
