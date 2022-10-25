public class PowerMethod {
    public static void algorithm(double[][] A) {
        double eps = 0.00001;
        int iterationsQuantity = 0;
        int n = A.length;
        double[] y_kMinusOne = {1, 0, 0, 0, 0};
        double[] y_k = new double[n];
        double[] tmp = new double[n];
        y_k = Matrix.multiplyMatrixByVector(A, y_kMinusOne);
        while(!criteria(y_k, y_kMinusOne, eps)) {
            for(int i = 0; i < n; i++)
                tmp[i] = y_k[i];
            y_k = Matrix.multiplyMatrixByVector(A, y_k);
            for(int i = 0; i < n; i++)
                y_kMinusOne[i] = tmp[i];
            iterationsQuantity++;
        }
        System.out.println("Iterations quantity:");
        System.out.println(iterationsQuantity);
        System.out.println("Max eigenvalue:");
        System.out.println(y_k[0] / y_kMinusOne[0]);
        System.out.println("Max eigenvalue's eigenvector:");
        for(int i = 0; i < n; i++)
            System.out.print(y_kMinusOne[i] / y_kMinusOne[0] + " ");
        System.out.println("Residual:");
        for(double res : Matrix.eigenVectorResidual(A, y_kMinusOne, y_k[0] / y_kMinusOne[0]))
            System.out.print(res + " ");
        System.out.println(Matrix.norm(Matrix.eigenVectorResidual(A, y_kMinusOne, y_k[0] / y_kMinusOne[0])));
        System.out.println();
        System.out.println(Matrix.eigenPolynomialResidual(KrylovMethod.algorithm(A), y_k[0] / y_kMinusOne[0]));
    }

    private static boolean criteria(double[] y_k, double[] y_kMinusOne, double eps) {
        double scale = Math.pow(eps, -1);
        double tmp = Math.ceil((y_k[0] / y_kMinusOne[0]) * scale) / scale;
        for(int i = 1; i < y_k.length; i++) {
            if((Math.ceil((y_k[i] / y_kMinusOne[i]) * scale) / scale) == tmp) {
                tmp = Math.ceil((y_k[i] / y_kMinusOne[i]) * scale) / scale;
            }
            else return false;
        }
        return true;
    }
}
