package renderer;

import maths.Vector3;

/**
 * Ta klasa implementuje najbardziej podstawowy kształt w grafice 3D - trójkąt.
 * @author Bartosz Węgrzyn
 */
public class Triangle {
    public final int nVerticies = 3;
    /**
     * Wartości wprowadzane do składowych wektora powinny wynosić od -1.0 do 1.0. <br>
     * (0, 0) - środek ekranu <br>
     * (-1, -1) - lewy dolny róg <br>
     * (1, 1) - prawy górny róg <br>
     * (-1, 1) - lewy górny róg <br>
     * (1, -1) - prawy dolny róg <br>
     * @author Bartosz Węgrzyn
     */
    public Vector3[] verticies = new Vector3[nVerticies];

}
