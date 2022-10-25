import static java.lang.Math.*;

public class JacobiMethod {
    public static void algorithm(double[][] A) {
        double[][] firstA = new double[A.length][A.length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A.length; j++)
                firstA[i][j] = A[i][j];
        double eps = 0.00001;
        int n = A.length;
        double[][] tmpQ = new double[n][n];
        double[][] Q = {{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}};
        double max = 1;
        int k = 0;
        int l = 0;
        double[][] E = {{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}};
        int iterationsQuantity = 0;
        double[][] Anull = new double[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                Anull[i][j] = A[i][j];

        while (max > eps) {
            max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(max) < Math.abs(A[i][j])) {
                        max = A[i][j];
                        k = i;
                        l = j;
                    }
                }
            }
            double phi = 0.5 * atan( (2 * A[k][l]) / (A[k][k] - A[l][l]) );
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    tmpQ[i][j] = E[i][j];
                }
            }
            tmpQ[k][k] =  cos(phi);
            tmpQ[k][l] = -sin(phi);
            tmpQ[l][k] =  sin(phi);
            tmpQ[l][l] =  cos(phi);

            A = Matrix.multiplyMatrices(Matrix.multiplyMatrices(Matrix.transposeMatrix(tmpQ), A), tmpQ);
            Q = Matrix.multiplyMatrices(Q, tmpQ);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        max += abs(A[i][j]);
                    }
                }
            }
            iterationsQuantity++;
        }
        System.out.println("Iterations quantity:");
        System.out.println(iterationsQuantity);
        System.out.println("Eigen vectors:");
        Q = Matrix.transposeMatrix(Q);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print((Q[i][j] / Q[i][0]) + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Eigen values on diagonal matrix:");
        for(double[] row : A) {
            for(double element : row) {
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Eigen values");
        for(int i = 0; i < n; i++) {
            System.out.print(A[i][i] + " ");
            System.out.println(Matrix.eigenPolynomialResidual(KrylovMethod.algorithm(firstA), A[i][i]));
            System.out.println();
        }

        System.out.println("Residual for each eigenvector: ");
        double[] eigenVector = new double[n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                eigenVector[j] = Q[i][j];
            for(double res : Matrix.eigenVectorResidual(Anull, eigenVector, A[i][i])) {
                System.out.print(res + " ");
                System.out.println();
            }
            System.out.println(Matrix.norm(Matrix.eigenVectorResidual(Anull, eigenVector, A[i][i])));
            System.out.println();
        }
    }
}
