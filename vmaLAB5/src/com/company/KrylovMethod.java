import static java.lang.Math.abs;

public class KrylovMethod {
    static public double[] gaussianEliminationForKrylovMethod(double[][] A, double[] b) {
        double det = 1;
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
            det *= A[k][k];
            if(max != k)
                det *= (-1);


            for (int i = k + 1; i < n; i++) {
                double c = A[i][k] / A[k][k];
                b[i] -= c * b[k];
                for (int j = k; j < n; j++)
                    A[i][j] -= c * A[k][j];
            }
        }

        if(det != 0.000) {
            double[] x = new double[n];
            for (int i = n - 1; i >= 0; i--) {
                double sum = 0.0000;
                for (int j = i + 1; j < n; j++)
                    sum += A[i][j] * x[j];
                x[i] = (b[i] - sum) / A[i][i];
            }
            return x;
        } else {
            for(int i = 1; i < n; i++) {
                if(A[i][i - 1] != 0.0000) {
                    double[][] newA = new double[i][i];
                    double[] newB = new double[i];
                    for(int j = 0; j < i; j++) {
                        newB[j] = b[j];
                        for(int k = 0; k < i; k++) {
                            newA[j][k] = A[j][k];
                        }
                    }
                    double[] x = new double[n];
                    for (int j = i - 1; j >= 0; j--) {
                        double sum = 0.0000;
                        for (int k = j + 1; k < i; k++)
                            sum += A[j][k] * x[k];
                        x[j] = (b[j] - sum) / A[j][j];
                    }
                    return x;
                }
            }
            return null;
        }
    }

    static public double[] algorithm(double[][] A) {
        int n = A.length;
        double[][] cVectors = new double[n + 1][n];
        cVectors[0][0] = 1.0;
        for(int i = 1; i < n; i++) {
            cVectors[0][i] = 0.0;
        }
        for(int i = 1; i < n + 1; i++) {
            cVectors[i] = Matrix.multiplyMatrixByVector(A, cVectors[i-1]);
        }
        System.out.println("\n");
        double[][] cMatrix = new double[n][n];
        cMatrix = Matrix.transposeMatrix(cVectors);
        double[] solution = new double[n];
        solution = gaussianEliminationForKrylovMethod(cMatrix, cVectors[n]);
        return solution;
    }
}
