package renderer;

import java.awt.*;
import java.util.ArrayList;

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
        for (int i = 0; i < triangles.size(); i++) {
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

    /**
     * Ta funkcja sortuje trójkąty według ich wzrastającej odległości z od kamery
     *
     * @author Bartosz Węgrzyn
     */
    public void sort() {
        for (int i = 0; i < triangles.size(); i++) {
            boolean swapped = false;
            for (int j = 0; j < triangles.size() - 1; j++) {
                if (triangles.get(i).avgDistance > triangles.get(j + 1).avgDistance) {
                    float temp = triangles.get(j).avgDistance;
                    triangles.get(j).avgDistance = triangles.get(j + 1).avgDistance;
                    triangles.get(j + 1).avgDistance = temp;
                    swapped = true;
                }
                if (!swapped) {
                    break;
                }
            }
        }
    }
}
