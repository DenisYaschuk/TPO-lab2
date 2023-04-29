public class NormalAlgorithm {
    private final Matrix aMatrix;
    private final Matrix bMatrix;
    public NormalAlgorithm(Matrix a, Matrix b) {
        this.aMatrix = a;
        this.bMatrix = b;
    }

    public Result multiplyMatrix() {
        Matrix resultMatrix = new Matrix(aMatrix.getSizeX(), bMatrix.getSizeY());
        long timestamp0 = System.nanoTime();

        for (int x = 0; x < aMatrix.getSizeX(); x++) {
            for (int y = 0; y < bMatrix.getSizeY(); y++) {
                for (int i = 0; i < aMatrix.getSizeY(); i++) {
                    resultMatrix.matrix[x][y] += aMatrix.matrix[x][i] * bMatrix.matrix[i][y];
                }
            }
        }

        long timestamp1 = System.nanoTime();
        return new Result(resultMatrix, ((timestamp1-timestamp0)/1000000));
    }
}
