class FoxThread extends Thread {
    private Matrix aMatrix;
    private Matrix bMatrix;
    private final int stepX;
    private final int stepY;
    private Matrix resultMatrix;

    public FoxThread(Matrix a, Matrix b, int x, int y, Matrix result) {
        this.aMatrix = a;
        this.bMatrix = b;
        this.stepX = x;
        this.stepY = y;
        this.resultMatrix = result;
    }

    @Override
    public void run(){
        for (int x = 0; x < aMatrix.getSizeX(); x++) {
            for (int y = 0; y < bMatrix.getSizeY(); y++) {
                for (int i = 0; i < bMatrix.getSizeX(); i++) {
                    resultMatrix.matrix[x + stepX][y + stepY] += aMatrix.matrix[x][i] * bMatrix.matrix[i][y];
                }
            }
        }
    }
}