package leetcode;


import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] solution = new int[n + 1];
        Arrays.fill(solution, Integer.MAX_VALUE);
        solution[0] = 0;
        solution[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                solution[i] = Math.min(solution[i], solution[i - j * j] + 1);
            }
        }
        return solution[n];
    }
    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(4635));
    }
}
