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
     * Mnoży każdy element tej macierzy przez skalar
     * @param n skalar
     * @author Bartosz Węgrzyn
     */
    public void multiplyn(float n) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] *= n;
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
    public Matrix3x3 multiply(Matrix3x3 matrix3x3) {
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
     * Podnosi tę macierz do kwadratu
     * @return druga potęga tej macierzy
     * @author Bartosz Węgrzyn
     */
    public Matrix3x3 square() {
        Matrix3x3 temp = new Matrix3x3(data);
        return multiply(temp);
    }

    /**
     * Oblicza minor tej macierzy
     * @param i "skreślany" rząd
     * @param j "skreślana" kolumna
     * @return minor
     * @author Bartosz Węgrzyn
     */
    public Matrix2x2 minor(int i, int j) {
        float result[][] = new float[2][2];
        int x = 0, y = 0;
        for (int a = 0; a < data.length; a++) {
            if (a == i)
                continue;
            for (int b = 0; b < data[0].length; b++) {
                if (b == j)
                    continue;
                result[x][y] = data[a][b];
                y++;
            }
            y = 0;
            x++;
        }
        return new Matrix2x2(result);
    }

    /**
     * Oblicza wyznacznik macierzy 3x3
     *
     * @return wyznacznik tej macierzy
     * @author Bartosz Węgrzyn
     */
    public float det() {
        float det = data[0][0] * minor(0, 0).det();
        det -= data[0][1] * minor(0, 1).det();
        det += data[0][2] * minor(0, 2).det();
        return det;
    }

    /**
     * Oblicza macierz odwrotną do tej macierzy
     * @return macierz odwrotna
     * @author Bartosz Węgrzyn
     */
    public Matrix3x3 inverse() {
        float result[][] = new float[data.length][data[0].length];
        float det = det();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = (float) (Math.pow(-1, i + j)*minor(j, i).det()/det());
            }
        }
        return new Matrix3x3(result);
    }


}
