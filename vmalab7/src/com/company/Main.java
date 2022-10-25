package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] A = new double[5][5];
        double[] eigValues = {0.780835, 0.62052, 0.457378, 0.205328, 0.152839  };
        File file = new File("A.txt");
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNext()) {
                String line = new String(scanner.nextLine());
                String[] lineArray = line.split(", ");
                for (int j = 0; j < 5; j++)
                    A[i][j] = Double.parseDouble(lineArray[j]);
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DanilevskiyMethod.algorithm(Matrix.multiplyMatrices(Matrix.transposeMatrix(A), A), eigValues);
    }
}


class DanilevskiyMethod {
    private static double[][] transformationMatrixToFrobeniusForm(double[][] A) {
        int n = A.length;
        double[][] R = new double[n][n];
        double[][] tmpR = new double[n][n];
        double[][] inverseR = new double[n][n];
        double[][] E = {{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}};
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                R[j][k] = E[j][k];
                tmpR[j][k] = E[j][k];
                inverseR[j][k] = E[j][k];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                tmpR[i + 1][j] = -A[i][j] / A[i][i + 1];
                tmpR[i + 1][i + 1] = 1 / A[i][i + 1];
                inverseR[i + 1][j] = A[i][j];
            }
            A = Matrix.multiplyMatrices(Matrix.multiplyMatrices(inverseR, A), tmpR);
            R = Matrix.multiplyMatrices(R, tmpR);
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    tmpR[j][k] = E[j][k];
                    inverseR[j][k] = E[j][k];
                }
            }
        }
        System.out.println("Canonical Frobenius form:");
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                System.out.print(A[j][k] + " ");
            }
            System.out.print("\n");
        }
        return R;
    }
    private static double[][] findEigenVectors(double[][] R, double[] eigenValues) {
        int n = R.length;
        double[][] FrobeniusEigenVectors = new double[n][n];
        double[][] eigenVectors = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                FrobeniusEigenVectors[i][j] = Math.pow(eigenValues[i], j);
            }
        }
        for(int i = 0; i < n; i++) {
            eigenVectors[i] = Matrix.multiplyMatrixByVector(R, FrobeniusEigenVectors[i]);
        }
        return eigenVectors;
    }

    public static double[][] algorithm(double[][] A, double[] eigenValues) {
        double[][] eigenVectors = new double[A.length][A.length];
        eigenVectors = findEigenVectors(transformationMatrixToFrobeniusForm(A), eigenValues);
        System.out.println("Eigen Vectors:");
        for (double[] vec : eigenVectors)
        {
            System.out.println("v = ( " + vec[0] + ", " + vec[1] + ", " + vec[2] + ", " + vec[3] + ", " + vec[4] + " )");
        }

        System.out.println("Residual:");
        for(int i = 0; i < A.length; i++) {
            for(double res : Matrix.eigenVectorResidual(A, eigenVectors[i], eigenValues[i])) {
                System.out.print(res + ", ");
            }
            System.out.println();
            System.out.println(Matrix.norm(Matrix.eigenVectorResidual(A, eigenVectors[i], eigenValues[i])));
            System.out.println();
        }
        return eigenVectors;
    }
}
