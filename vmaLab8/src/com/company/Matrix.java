package com.company;

public class Matrix {
    static double[] multiplyMatrixByVector(double[][] A, double[] x) {
        double[] product = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                product[i] += A[i][j] * x[j];
            }
        }
        return product;
    }

    static double[][] transpose(double [][] A){
        double[][] result = new double[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[j][i] = A[i][j];
        return result;
    }

    static double[][] multiplyMatrices(double[][] A, double[][] B) {
        double[][] product = new double[A.length][B[0].length];
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[i].length; j++) {
                product[i][j] = Matrix.multiplyMatricesCell(A, B, i, j);
            }
        }
        return product;
    }

    static double multiplyMatricesCell(double[][] A, double[][] B, int row, int col) {
        double cell = 0;
        for (int i = 0; i < B.length; i++) {
            cell += A[row][i] * B[i][col];
        }
        return cell;
    }

    public static void main(String[] args) {
        double[][] A =  {
                {0.7474, 0.0000, -0.1939, 0.1364, 0.2273},
                {-0.0455, 0.4848, 0.0000, -0.0924, 0.0303},
                {0.0152, -0.1364, 0.8787, 0.0167, 0.0530},
                {0.0455, 0.0000, -0.1106, 0.8787, 0.0000},
                {0.0303, -0.0455, 0.2197, -0.0182, 0.6363}
        };
        double eps = 10e-5;
        double[][] newA = multiplyMatrices(A, transpose(A));

        int numOfIter = 0;
        double[] y_kMinusOne = {1, 0, 0, 0, 0};
        double[] y_k = Matrix.multiplyMatrixByVector(newA, y_kMinusOne);
        double lambda = 1, prevLambda = 0, tmpLambda = 0;
        while (Math.abs(lambda - prevLambda) > eps) {
            tmpLambda = 0;
            prevLambda = lambda;
            for (int i = 0; i < 5; i++) {
                y_kMinusOne[i] = y_k[i];
            }
            y_k = Matrix.multiplyMatrixByVector(newA, y_kMinusOne);
            for (int i = 0; i < 5; i++) {
                tmpLambda += y_k[i] / y_kMinusOne[i];
            }
            lambda = tmpLambda / 5;
            numOfIter++;
        }

        System.out.println("максимальное собственное значение: " + lambda);
        System.out.println("собственный вектор: ( " + y_k[0] + ", " + y_k[1] + ", " + y_k[2] + ", " + y_k[3] + ", " + y_k[4] + " )");
        System.out.println("количество итераций: " + numOfIter);

        double[] r = {0 ,0 ,0 , 0, 0};
        for (int i = 0; i < 5; i++) {
            r[i] = multiplyMatrixByVector(newA, y_k)[i] - lambda * y_k[i];
        }

        System.out.println();
        System.out.println("невязка: ( " + r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3] + ", " + r[4] + " )");
    }
}
