package main;

import maths.Matrix2x2;
import maths.Matrix3x3;
import maths.Vector2;
import maths.Vector3;
import util.Console;

/**
 * Tymczasowa klasa przeznaczona do testowania klas z packagu maths
 *
 * @author Bartosz Węgrzyn
 */
public class MathsTest {
    public void test() {
        Vector3 v3a = new Vector3(6, -5, 3);
        Matrix3x3 m1 = new Matrix3x3(new float[][]{{10, -7, 12}, {-13, 5, 4}, {-5, 3, -15}});
        Matrix3x3 m2 = new Matrix3x3(new float[][]{{-4, 2, -18}, {-8, -4, 1}, {-5, 17, -4}});

        (m1.square()).print();
    }
}
