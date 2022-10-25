package com.company;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Matrix2 {
    static double[] multiplyMatrixByVector(double[][] A, double[] x) {
        double[] product = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                product[i] += A[i][j] * x[j];
            }
        }
        return product;
    }

    static double[][] transposeMatrix(double [][] A){
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
                product[i][j] = multiplyMatricesCell(A, B, i, j);
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

    static public double[] gaussianElimination(double[][] A, double[] b)
    {
        int n = b.length;
        for (int k = 0; k < n; k++)
        {
            int max = k;
            for (int i = k + 1; i < n; i++)
                if (abs(A[i][k]) > abs(A[max][k]))
                    max = i;

            double[] tmpArray = A[k];
            A[k] = A[max];
            A[max] = tmpArray;
            double tmp = b[k];
            b[k] = b[max];
            b[max] = tmp;

            for (int i = k + 1; i < n; i++)
            {
                double c = A[i][k] / A[k][k];
                b[i] -= c * b[k];
                for (int j = k; j < n; j++)
                    A[i][j] -= c * A[k][j];
            }

        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--)
        {
            double sum = 0.0000;
            for (int j = i + 1; j < n; j++)
                sum += A[i][j] * x[j];
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    static double[] residual(double[][] A, double[] x, double[] b) {
        double[] residual = new double[x.length];
        for(int i = 0; i < x.length; i++) {
            residual[i] = multiplyMatrixByVector(A, x)[i] - b[i];
        }
        return residual;
    }

    static double norm(double[] x) {
        double norm = 0;
        for (int i = 0; i < x.length; i++) {
            if (Math.abs(x[i]) > norm) {
                norm = Math.abs(x[i]);
            }
        }
        return norm;
    }

    static double eigenPolynomialResidual(double[] polynomial, double eigenValue) {
        double residual = -pow(eigenValue, 5);
        for(int i = 0; i < polynomial.length; i++) {
            residual += polynomial[i] * pow(eigenValue, i);
        }
        return residual;
    }

    static double[] eigenVectorResidual(double[][] A, double[] eigenVector, double eigenValue) {
        double[] residual = new double[eigenVector.length];
        double[] tmp = new double[eigenVector.length];
        tmp = (Matrix.multiplyMatrixByVector(A, eigenVector));
        for(int i = 0; i < tmp.length; i++)
            residual[i] = tmp[i] - eigenValue * eigenVector[i];
        return residual;
    }
}
