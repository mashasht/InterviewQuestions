package leetcode;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                perimeter += exploreNeighbors(i, j, grid);
            }
        }
        return perimeter;
    }
    private int exploreNeighbors(int i, int j, int[][] grid) {
        int cellPerimeter = 0;
        if (grid[i][j] == 0) {
            return 0;
        }
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            cellPerimeter++;
        }
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            cellPerimeter++;
        }
        if (i + 1 == grid.length || grid[i + 1][j] == 0) {
            cellPerimeter++;
        }
        if (j + 1 == grid[0].length || grid[i][j + 1] == 0) {
            cellPerimeter++;
        }
        return cellPerimeter;
    }
    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(ip.islandPerimeter(grid));
    }
}
