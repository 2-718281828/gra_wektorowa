package maths;

import util.Console;

/**
 * Ta klasa zawiera wszystkie operacje na macierzach wymiarów 2x2
 *
 * @author Bartosz Węgrzyn
 */
public class Matrix2x2 {
    public float[][] data;

    /**
     * Konstruktor
     *
     * @param data tablica float 2D z danymi do macierzy
     * @author Bartosz Węgrzyn
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
     * Wypisuje wartości macierzy do konsoli
     *
     * @author Bartosz Węgrzyn
     */
    public void print() {
        String msg = "[ ";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                msg += data[i][j] + " ";
            }
            if (i != data.length - 1)
                msg += "\n";
        }
        msg += "]";
        Console.log(msg);
    }

    /**
     * Dodaje inną macierz do tej
     *
     * @param matrix2x2 macierz, którą dodajemy
     * @author Bartosz Węgrzyn
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
     * @author Bartosz Węgrzyn
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
     * @author Bartosz Węgrzyn
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
     * @author Bartosz Węgrzyn
     */
    public float det() {
        float det = data[0][0] * data[1][1] - data[1][0] * data[0][1];
        return det;
    }
}
