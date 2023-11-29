package maths;

/**
 * Ta klasa zawiera wszystkie operacje na macierzach wymiarów 2x2
 *
 * @author Bartosz W
 */
public class Matrix2x2 {
    public float[][] data;

    /**
     * Konstruktor
     *
     * @param data tablica float 2D z danymi do macierzy
     * @author Bartosz W
     */
    public Matrix2x2(float[][] data) {
        if (data.length != 2 && data[0].length != 2) {
            try {
                throw new Exception("Złe wymiary macierzy");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.data = data;
    }

    /**
     * Dodaje inną macierz do tej
     *
     * @param matrix2x2 macierz, którą dodajemy
     * @author Bartosz W
     */
    public void add(Matrix2x2 matrix2x2) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] += matrix2x2.data[i][j];
            }
        }
    }

    /**
     * Odejmuje inną macierz od tej
     *
     * @param matrix2x2 macierz, którą odejmujemy
     * @author Bartosz W
     */
    public void subtract(Matrix2x2 matrix2x2) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] -= matrix2x2.data[i][j];
            }
        }
    }

    /**
     * Mnoży tę oraz inną macierz 2x2
     *
     * @param matrix2x2 macierz razy którą mnożymy
     * @return wynik mnożenia, nowa macierz 2x2
     * @author Bartosz W
     */
    public Matrix2x2 mulitply(Matrix2x2 matrix2x2) {
        float[][] result = new float[data.length][data[0].length];
        result[0][0] = data[0][0] * matrix2x2.data[0][0] + data[0][1] * matrix2x2.data[1][0];
        result[0][1] = data[0][0] * matrix2x2.data[0][1] + data[0][1] * matrix2x2.data[1][1];
        result[1][0] = data[1][0] * matrix2x2.data[0][0] + data[1][1] * matrix2x2.data[1][0];
        result[1][0] = data[1][0] * matrix2x2.data[0][1] + data[1][1] * matrix2x2.data[1][1];
        return new Matrix2x2(result);
    }

    /**
     * Oblicza wyznacznik macierzy 2x2
     *
     * @return wyznacznik tej macierzy
     * @author Bartosz W
     */
    public float det() {
        float det = data[0][0] * data[1][1] - data[1][0] * data[0][1];
        return det;
    }
}
