package maths;

/**
 * Ta klasa zawiera wszystkie operacje na macierzach wymiarów 2x2
 *
 * @author Bartosz W
 */
public class Matrix2x2 {
    public float a1, a2, b1, b2; // a - wiersze, b - kolumny

    /**
     * Konstruktor <br>
     * W parametrach litera oznacza wiersz, cyfra kolumnę
     *
     * @param a1
     * @param a2
     * @param b1
     * @param b2
     * @author Bartosz W
     */
    public Matrix2x2(float a1, float a2, float b1, float b2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
    }

    /**
     * Dodaje inną macierz do tej
     *
     * @param matrix2x2 macierz, którą dodajemy
     * @author Bartosz W
     */
    public void add(Matrix2x2 matrix2x2) {
        this.a1 += matrix2x2.a1;
        this.a2 += matrix2x2.a2;
        this.b1 += matrix2x2.b1;
        this.b2 += matrix2x2.b2;
    }

    /**
     * Odejmuje inną macierz od tej
     *
     * @param matrix2x2 macierz, którą odejmujemy
     * @author Bartosz W
     */
    public void subtract(Matrix2x2 matrix2x2) {
        this.a1 -= matrix2x2.a1;
        this.a2 -= matrix2x2.a2;
        this.b1 -= matrix2x2.b1;
        this.b2 -= matrix2x2.b2;
    }

    /**
     * Mnoży tę oraz inną macierz 2x2
     * @param matrix2x2 macierz razy którą mnożymy
     * @return wynik mnożenia, nowa macierz 2x2
     * @author Bartosz W
     */
    public Matrix2x2 mulitply(Matrix2x2 matrix2x2) {
        return new Matrix2x2(a1* matrix2x2.a1+a2* matrix2x2.b1, a1*matrix2x2.a2+a2* matrix2x2.b2,
                b2* matrix2x2.b1+b1* matrix2x2.a1, b1* matrix2x2.a2+b2* matrix2x2.b2);
    }

    /**
     * Oblicza wyznacznik macierzy 2x2
     * @return wyznacznik tej macierzy
     * @author Bartosz W
     */
    public float det() {
        return a1*b2-a2*b1;
    }
}
