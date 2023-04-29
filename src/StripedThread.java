
class StripedThread extends Thread {
    private final Matrix matrix;
    private final double[] strip;
    private final int index;
    private final Matrix resultMatrix;
    public StripedThread(Matrix matrix, double[] matrixRow, int rowIndex, Matrix resultObj){
        this.matrix = matrix;
        this.strip = matrixRow;
        this.index = rowIndex;
        this.resultMatrix = resultObj;
    }
    @Override
    public void run(){
        for (int y = 0; y < matrix.getSizeY(); y++) {
            for (int x = 0; x < strip.length; x++) {
                resultMatrix.matrix[index][y] += strip[x] * matrix.matrix[x][y];
            }
        }
    }
}