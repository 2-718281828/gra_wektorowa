package maths;

/**
 * Ta klasa zawiera wszystkie potrzebne funckje do operacji na wektorach
 * @author BARTOSZ
 * @see Vector3
 */
public class Vector2 {
    public float x, y;

    /**
     * Ten konstruktor tworzy nowy obiekt Vector2
     * @param x składowa x wektora
     * @param y składowa y wektora
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Ta funckja dodaje inny dwuwymiarowy wektor do tego wektora
     * @param vector2 dodawany wektor
     */
    public void add(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
    }

    /**
     * Ta funckja mnoży każdą składową wektora przez skalar
     * @param n skalar
     */
    public void multiply(float n) {
        this.x *= n;
        this.y *= n;
    }

    /**
     * Ta funkcja zwraca długość (moduł) wektora
     * @return moduł tego wektora
     */
    public float magnitude() {
        return (float) Math.sqrt(x*x+y*y);
    }

    /**
     * Ta funkcja wykonuje operację iloczynu wektorowego
     * @param vector2 drugi wektor w iloczynie wektorowym (kolejność tu nie ma znaczenia)
     * @return zwraca wartość iloczynu wektorowego tego wektora i wektora z argumentu
     */
    public float dot(Vector2 vector2) {
        return x* vector2.x+y* vector2.y;
        /* iloczyn wektorowy: a dot b = ax*bx+ay*by+az*bz, tu nie mamy
        * trzeciego kierunku z, więc po prostu ax*bx+ay*by*/
    }

    /**
     * Ta funckja oblicza długość iloczynu wektorowego
     * @param vector2 wektor z którym wykonujemy iloczyn wektorowy (tu kolejność nie ma znaczenia, ponieważ jest to sama długość, a nie wektor)
     * @return długość iloczynu wektorowego tego wektora z wektorem z argumentu
     */
    public float crossMg(Vector2 vector2) {
        float v = this.dot(vector2) / (this.magnitude() * vector2.magnitude());
        float theta = (float) Math.acos(v); // obliczamy kąt ze wzoru
        return (float) (Math.sin(theta) * this.magnitude() * vector2.magnitude());
        /* obliczamy DŁUGOŚĆ iloczynu wektorowego ze wzoru |a x b| = |a|*|b|*sin(theta), gdzie theta to kąt
        * między wektorami */
    }
}
