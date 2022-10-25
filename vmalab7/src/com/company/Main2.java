package com.company;

public class Main2 {

    public static void main(String[] args) {
        double[][] A =  {
            {0.7474, 0.0000, -0.1939, 0.1364, 0.2273},
            {-0.0455, 0.4848, 0.0000, -0.0924, 0.0303},
            {0.0152, -0.1364, 0.8787, 0.0167, 0.0530},
            {0.0455, 0.0000, -0.1106, 0.8787, 0.0000},
            {0.0303, -0.0455, 0.2197, -0.0182, 0.6363}
        };
        double[] eigValues = {1.003785, 1.003785, 0.586396, 0.143649, 0.143649};
        aloth.algorithm(Matrix.multiplyMatrices(Matrix.transposeMatrix(A), A), eigValues);
    }
}
