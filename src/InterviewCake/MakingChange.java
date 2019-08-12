package InterviewCake;

import java.util.LinkedList;
import java.util.List;
// TODO: fix me
public class MakingChange {
    public static List<List<Integer>> makeChange(int sum, int[] denominations) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> intermediateResult = new LinkedList<>();
        return makeRecursiveChange(result, intermediateResult, sum, denominations);
    }

    public static List<List<Integer>> makeRecursiveChange(List<List<Integer>> result, List<Integer> intermediateResult,
                                                          int sum, int[] denominations) {
        if (sum == 0) {
            result.add(intermediateResult);
            return result;
        }
        if (sum < 0) {
            return result;
        }
        for (int i = 0; i < denominations.length; i++) {
            int newSum = sum - denominations[i];
            List<Integer> newIntermediateResult = new LinkedList<>(intermediateResult);
            newIntermediateResult.add(denominations[i]);
            makeRecursiveChange(result, newIntermediateResult, newSum, denominations);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(makeChange(4, denominations));
    }
}
