package FindingPeak;

import java.util.Optional;

/**
 * Created by mashashtutman on 2019-02-24.
 */
class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        return "i=" + this.i + ", j=" + this.j;
    }
}

public class FindingPeak {

    public static Optional<Pair> findPeakInTwoDimentionalMatrix(int[][] matrix, int start, int finish) {
        if (finish - start < 0){
            return Optional.empty();
        }
        int j = (finish - start)/2;
        int i = returnColumnMax(matrix, j);
        if ((j == 0 || matrix[i][j] >= matrix[i][j - 1]) && (j == matrix[i].length || matrix[i][j] >= matrix[i][j + 1])) {
            return Optional.of(new Pair(i, j));
        }
        if (matrix[i][j - 1] > matrix[i][j]) {
            return findPeakInTwoDimentionalMatrix(matrix, 0, j - 1);
        }
        if (matrix[i][j + 1] > matrix[i][j]) {
            return findPeakInTwoDimentionalMatrix(matrix, j + 1, finish);
        }
        return Optional.empty();
    }

    private static int returnColumnMax(int[][] matrix, int column){
        int max = matrix[0][column];
        int indexMax = 0;
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][column] > max) {
                max = matrix[i][column];
                indexMax = i;
            }
        }
       return indexMax;
    }
    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        matrix[1][0] = 1;
        matrix[1][1] = -2;
        matrix[1][2] = 1;
        matrix[2][0] = 2;
        matrix[2][1] = 1;
        matrix[2][2] = 5;
        Optional<Pair> result = findPeakInTwoDimentionalMatrix(matrix, 0, matrix.length);
        if (result.isPresent()) {
            System.out.println(result.get());
        }
    }
}
