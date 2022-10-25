package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] A = new double[5][5];
        double[] b = new double[5];
        double[] wolframEigenValues = {0.780835, 0.62052, 0.457378, 0.205328, 0.152839  };
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
        double[][] newA = new double[A.length][A.length];
        newA = Matrix.multiplyMatrices(Matrix.transposeMatrix(A), A);
            for(double[] row : newA) {
            for(double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.print("\n");
        }
 /*       System.out.println("Krylov Method");
        for(double element : KrylovMethod.algorithm(newA))
            System.out.print(element + " ");
        System.out.println("Residual");
        for(double eigenValue : wolframEigenValues)
            System.out.print(Matrix.eigenPolynomialResidual(KrylovMethod.algorithm(newA), eigenValue) + " ");
        System.out.println("\nDanilevskiy Method");
        double[] eigenValues
                = {0.15283885916974, 0.2053278255729, 0.4573780888996, 0.62205202414972, 0.7808349448606};
        System.out.println("Eigen vectors:");
        for(double[] row : DanilevskiyMethod.algorithm(newA, eigenValues)) {
            for(double element : row) {
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }*/
        System.out.println("Jacobi Method");
        JacobiMethod.algorithm(newA);
        /*System.out.println("Power Method");
        PowerMethod.algorithm(newA);*/
    }
}
