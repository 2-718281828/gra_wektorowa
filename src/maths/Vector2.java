package maths;

/**
 * Ta klasa zawiera wszystkie potrzebne funckje do operacji na wektorach 2D
 *
 * @author Bartosz Węgrzyn
 */
public class Vector2 {
  public double x, y;

  /**
   * Konstruktor
   *
   * @param x składowa x wektora
   * @param y składowa y wektora
   * @author Bartosz Węgrzyn
   */
  public Vector2(double x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Konstruktor
   *
   * @param vector2 wektor, którego dane chcemy skopiować
   * @author Bartosz Węgrzyn
   */
  public Vector2(Vector2 vector2) {
    this.x = vector2.x;
    this.y = vector2.y;
  }

  /**
   * Wypisuje w konsoli wartości składowych tego wektora
   *
   * @author Bartosz Węgrzyn
   */
  public void print() {
    System.out.println("X: " + x + ", Y: " + y);
  }

  /**
   * Ta funckja dodaje inny dwuwymiarowy wektor do tego wektora
   *
   * @param vector2 dodawany wektor
   * @author Bartosz Węgrzyn
   */
  public void add(Vector2 vector2) {
    this.x += vector2.x;
    this.y += vector2.y;
  }

  /**
   * Ta funckja odejmuje inny dwuwymiarowy wektor do tego wektora
   *
   * @param vector2 odejmowany wektor
   * @author Bartosz Węgrzyn
   */
  public void subtract(Vector2 vector2) {
    this.x -= vector2.x;
    this.y -= vector2.y;
  }

  /**
   * Ta funckja mnoży każdą składową wektora przez skalar
   *
   * @param n skalar
   * @author Bartosz Węgrzyn
   */
  public void multiply(double n) {
    this.x *= n;
    this.y *= n;
  }

  /**
   * Ta funkcja zwraca długość (moduł) wektora
   *
   * @return moduł tego wektora
   * @author Bartosz Węgrzyn
   */
  public double magnitude() {
    return (double) Math.sqrt(x * x + y * y);
  }

  /**
   * Ta funkcja wykonuje operację iloczynu skalarnego
   *
   * @param vector2 drugi wektor w iloczynie skalarnym (kolejność tu nie ma
   *                znaczenia)
   * @return zwraca wartość iloczynu skalarnego tego wektora i wektora z argumentu
   * @author Bartosz Węgrzyn
   */
  public double dot(Vector2 vector2) {
    return x * vector2.x + y * vector2.y;
    /*
     * iloczyn skalarny: a dot b = ax*bx+ay*by+az*bz, tu nie mamy
     * trzeciego kierunku z, więc po prostu ax*bx+ay*by
     */
  }

  /**
   * Ta funckja oblicza długość iloczynu wektorowego
   *
   * @param vector2 wektor z którym wykonujemy iloczyn wektorowy (tu kolejność nie
   *                ma znaczenia, ponieważ jest to sama długość, a nie wektor)
   * @return długość iloczynu wektorowego tego wektora z wektorem z argumentu
   * @author Bartosz Węgrzyn
   */
  public double crossMg(Vector2 vector2) {
    return cross(vector2).magnitude();
  }

  /**
   * Ta funkcja oblicza iloczyn wektorowy 2 dwuwymiarowych wektorów
   *
   * @param vector2 wektor z którym liczony jest iloczyn wektorowy (tu kolejność
   *                ma znaczenie, definicja iloczynu wektorowego)
   * @return nowy trójwymiarowy wektor skierowany prostopadle do płaszczyzny, na
   *         której leżą wektory, czyli wzdłuż osi z
   * @author Bartosz Węgrzyn
   */
  public Vector3 cross(Vector2 vector2) {
    return new Vector3(0, 0, x * vector2.y - y * vector2.x); // definicja iloczynu wektorowego
  }
}
