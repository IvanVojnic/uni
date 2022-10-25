package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] A = new double[5][5];

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
        double eps = 10e-5;
        double[][] newA = Matrix.multiplyMatrices(Matrix.transpose(A),A);
        //double[][] newB = inversion(newA, 5);

        double[] y_k = {1, 1, 1, 1, 1};
        double lambda = 1;
        double lambda1 = Matrix.multiplyMatrixByVector(newA, y_k)[0];
        y_k = Matrix.multiplyMatrixByVector(newA, y_k);
        double[] y_k1 = Matrix.multiplyMatrixByVector(newA, y_k);
        int countOfIter = 0;
        while (lambda > eps) {
            y_k1 = Matrix.multiplyMatrixByVector(newA, y_k);
            double maxLambda = y_k1[0] / y_k[0];
            lambda = Math.abs(maxLambda - lambda1);
            lambda1 = maxLambda;
            y_k = y_k1;
            countOfIter++;
        }
        System.out.println(countOfIter);
        System.out.println("максимальное собственное значение: " + lambda1);

        System.out.println("собственный вектор: ( " + y_k1[0] + ", " + y_k1[1] + ", " + y_k1[2] + ", " + y_k1[3] + ", " + y_k1[4] + " )");

        double[] r = {0 ,0 ,0 , 0, 0};
        for (int i = 0; i < 5; i++) {
            r[i] = Matrix.multiplyMatrixByVector(newA, y_k)[i] - lambda * y_k[i];
        }

        System.out.println();
        System.out.println("невязка: ( " + r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3] + ", " + r[4] + " )");
    }
}

