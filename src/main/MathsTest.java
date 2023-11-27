package main;

import maths.Vector2;
import util.Console;

/**
 * Tymczasowa klasa przeznaczona do testowania klas z packagu maths
 *
 * @author Bartosz W
 */
public class MathsTest {
    public void test() {
        Vector2 v2a = new Vector2(10, -5);
        Vector2 v2b = new Vector2(-7, 3);
        (v2a.cross(v2b)).print(); // testowanko
    }
}
