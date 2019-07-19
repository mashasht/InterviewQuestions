package Pramp;


/**
 *
 * Created by mashashtutman on 2019-06-14.
 * Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns the number of
 * islands of 1s in binaryMatrix.
 * An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is considered adjacent
 * to another cell if they are next to each either on the same row or column. Note that two values of 1 are not part of
 * the same island if they’re sharing only a mutual “corner” (i.e. they are diagonally neighbors).
 * Explain and code the most efficient solution possible and analyze its time and space complexities.

 Example:

 input:  binaryMatrix = [ [0,    1,    0,    1,    0],
 [0,    0,    1,    1,    1],
 [1,    0,    0,    1,    0],
 [0,    1,    1,    0,    0],
 [1,    0,    1,    0,    1] ]

 output: 6 # since this is the number of islands in binaryMatrix.
 # See all 6 islands color-coded
 */
public class NumberOfIslands {

    int getNumberOfIslands(int[][] binaryMatrix) {
        boolean[][] visited = new boolean[binaryMatrix.length][binaryMatrix[0].length];
        int islandCount = 0;
      for (int i = 0; i < binaryMatrix.length; i++) {
          for (int j = 0; j < binaryMatrix[0].length; j++) {
              if (binaryMatrix[i][j] == 1 && visited[i][j] == false) {
                  visit(binaryMatrix, i, j, visited);
                  islandCount++;
              }
          }
      }
      return islandCount;
    }
    private void visit(int[][] binaryMatrix, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i + 1  < binaryMatrix.length && binaryMatrix[i + 1][j] == 1 && !visited[i + 1][j]) {
            visit(binaryMatrix, i + 1, j, visited);
        }
        if (i - 1  >= 0 && binaryMatrix[i - 1][j] == 1 && !visited[i - 1][j]) {
            visit(binaryMatrix, i - 1, j, visited);
        }
        if (j + 1  < binaryMatrix[0].length && binaryMatrix[i][j + 1] == 1 && !visited[i][j + 1]) {
            visit(binaryMatrix, i, j + 1, visited);
        }
        if (j - 1  >= 0 && binaryMatrix[i][j - 1] == 1 && !visited[i][j - 1]) {
            visit(binaryMatrix, i, j - 1, visited);
        }
    }
}

/*
[ 0, 1]
[1, 0]

[false, true]
[false, false]


[false, true]
[true, false]
 */