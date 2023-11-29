package maths;

/**
 * Ta klasa zawiera wszystkie potrzebne funckje do operacji na wektorach 3D
 *
 * @author Bartosz Węgrzyn
 * @see Vector2
 */
public class Vector3 {
    public float x, y, z;

    /**
     * Konstruktor
     *
     * @param x składowa x wektora
     * @param y składowa y wektora
     * @param z składowa z wektora
     * @author Bartosz Węgrzyn
     */
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Wypisuje w konsoli wartości składowych tego wektora
     *
     * @author Bartosz Węgrzyn
     */
    public void print() {
        System.out.println("X: " + x + ", Y: " + y + ", Z: " + z);
    }

    /**
     * Ta funckja dodaje inny trójwymiarowy wektor do tego wektora
     *
     * @param vector3 dodawany wektor
     * @author Bartosz Węgrzyn
     */
    public void add(Vector3 vector3) {
        this.x += vector3.x;
        this.y += vector3.y;
        this.z += vector3.z;
    }

    /**
     * Ta funckja odejmuje inny trójwymiarowy wektor do tego wektora
     *
     * @param vector3 odejmowany wektor
     * @author Bartosz Węgrzyn
     */
    public void subtract(Vector3 vector3) {
        this.x -= vector3.x;
        this.y -= vector3.y;
        this.z -= vector3.z;
    }

    /**
     * Ta funckja mnoży każdą składową wektora przez skalar
     *
     * @param n skalar
     * @author Bartosz Węgrzyn
     */
    public void multiply(float n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
    }

    /**
     * Ta funkcja zwraca długość (moduł) wektora
     *
     * @return moduł tego wektora
     * @author Bartosz Węgrzyn
     */
    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Ta funkcja wykonuje operację iloczynu skalarnego
     *
     * @param vector3 drugi wektor w iloczynie skalarnym (kolejność tu nie ma znaczenia)
     * @return zwraca wartość iloczynu skalarnego tego wektora i wektora z argumentu
     * @author Bartosz Węgrzyn
     */
    public float dot(Vector3 vector3) {
        return x * vector3.x + y * vector3.y + z * vector3.z;
        /* iloczyn skalarny: a dot b = ax*bx+ay*by+az*bz*/
    }

    /**
     * Ta funckja oblicza długość iloczynu wektorowego
     *
     * @param vector3 wektor z którym wykonujemy iloczyn wektorowy (tu kolejność nie ma znaczenia, ponieważ jest to sama długość, a nie wektor)
     * @return długość iloczynu wektorowego tego wektora z wektorem z argumentu
     * @author Bartosz Węgrzyn
     */
    public float crossMg(Vector3 vector3) {
        return cross(vector3).magnitude();
    }

    /**
     * Ta funkcja oblicza iloczyn wektorowy 2 trójwymiarowych wektorów
     *
     * @param vector3 wektor z którym liczony jest iloczyn wektorowy (tu kolejność ma znaczenie, definicja iloczynu wektorowego)
     * @return nowy trójwymiarowy wektor skierowany prostopadle do płaszczyzny, na której leżą wektory
     * @author Bartosz Węgrzyn
     */
    public Vector3 cross(Vector3 vector3) {
        return new Vector3(y * vector3.z - z * vector3.y, x * vector3.z - z * vector3.x, y * vector3.z - z * vector3.y);
        // definicja iloczynu wektorowego
    }
}
