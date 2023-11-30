package maths;

import util.Console;

/**
 * Ta klasa zawiera wszystkie operacje na macierzach wymiarów 3x3
 *
 * @author Bartosz Węgrzyn
 */
public class Matrix3x3 {
    public float[][] data;

    /**
     * Konstruktor
     *
     * @param data tablica float 2D z danymi do macierzy
     * @author Bartosz Węgrzyn
     */
    public Matrix3x3(float[][] data) {
        if (data.length != 3 && data[0].length != 3) {
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
     * @param matrix3x3 macierz, którą dodajemy
     * @author Bartosz Węgrzyn
     */
    public void add(Matrix3x3 matrix3x3) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] += matrix3x3.data[i][j];
            }
        }
    }

    /**
     * Odejmuje inną macierz od tej
     *
     * @param matrix3x3 macierz, którą odejmujemy
     * @author Bartosz Węgrzyn
     */
    public void subtract(Matrix3x3 matrix3x3) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] -= matrix3x3.data[i][j];
            }
        }
    }

    /**
     * Mnoży tę oraz inną macierz 3x3
     *
     * @param matrix3x3 macierz razy którą mnożymy
     * @return wynik mnożenia, nowa macierz 3x3
     * @author Bartosz Węgrzyn
     */
    public Matrix3x3 mulitply(Matrix3x3 matrix3x3) {
        float[][] result = new float[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                float sum = 0;
                for (int k = 0; k < data.length; k++) {
                    sum += data[i][k] * matrix3x3.data[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new Matrix3x3(result);
    }

    /**
     * Oblicza wyznacznik macierzy 3x3
     *
     * @return wyznacznik tej macierzy
     * @author Bartosz Węgrzyn
     */
    public float det() {
        float det = data[0][0] * new Matrix2x2(new float[][]{{data[1][1], data[1][2]},{data[2][1],data[2][2]}}).det();
        det -= data[0][1] * new Matrix2x2(new float[][]{{data[1][0], data[1][2]},{data[2][0],data[2][2]}}).det();
        det += data[0][2] * new Matrix2x2(new float[][]{{data[1][0], data[1][1]},{data[2][0],data[2][1]}}).det();
        return det;
    }
}
