package renderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Model 3D
 * @author Bartosz Węgrzyn
 */
public class Model {
    public ArrayList<Triangle> triangles = new ArrayList<>();
    public Color color;

    /**
     * Tworzy nowy obiekt model
     * @param triangles lista trójkątów
     * @param color kolor modelu (jeden kolor na model)
     * @author Bartosz Węgrzyn
     */
    public Model(ArrayList<Triangle> triangles, Color color) {
        this.triangles = triangles;
        this.color = color;
    }
}
