package Pramp;

/**
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in
 * order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance
 * between them. Explain how your function works, and analyze its time and space complexities.

 Examples:

 input:  str1 = "dog", str2 = "frog"
 output: 3

 input:  str1 = "some", str2 = "some"
 output: 0

 input:  str1 = "some", str2 = "thing"
 output: 9

 input:  str1 = "", str2 = ""
 output: 0
 */
public class DeletionDistances {
    static int[][] memo;

    static int getDeletionDistance(String str1, String str2){
        return getRecursiveDistanceWithMemo(str1, str2, 0, 0);
    }

    static int getRecursiveDistanceWithMemo(String str1, String str2, int index1, int index2) {
        initializeMemo(str1, str2);

        if (index1 == str1.length()) {
            return str2.length() - index2;
        }
        if (index2 == str2.length()) {
            return str1.length() - index1;
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            if (memo[index1 + 1][index2 + 1] == -1) {
                memo[index1 + 1][index2 + 1] = getRecursiveDistance(str1, str2, index1 + 1, index2 + 1);
            }
            return memo[index1 + 1][index2 + 1];
        }
        if (memo[index1 + 1][index2] == -1) {
            memo[index1 + 1][index2] = getRecursiveDistance(str1, str2, index1 + 1, index2);
        }
        if (memo[index1][index2 + 1] == -1) {
            memo[index1][index2 + 1] = getRecursiveDistance(str1, str2, index1, index2 + 1);
        }
        return 1 + Math.min(memo[index1 + 1][index2], memo[index1][index2 + 1]);
    }
    private static void initializeMemo(String str1, String str2){
        int shortestLength = Math.min(str1.length(), str2.length());
        memo = new int[shortestLength][shortestLength];
        for (int i = 0; i < shortestLength; i++) {
            for (int j = 0; j < shortestLength; j++) {
                memo[i][j] = -1;
            }
        }
    }
    // 1, 0; 0, 1
    // 2, 0; 1, 1;; 1, 1; 1, 2
    // 3, 0; 2, 1; 2, 1; 1, 2;;
    static int getRecursiveDistance(String str1, String str2, int index1, int index2) {
        if (index1 == str1.length()) {
            return str2.length() - index2;
        }
        if (index2 == str2.length()) {
            return str1.length() - index1;
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            return  getRecursiveDistance(str1, str2, index1 + 1, index2 + 1);
        }
        return 1 + Math.min(getRecursiveDistance(str1, str2, index1 + 1, index2),
                getRecursiveDistance(str1, str2, index1, index2 + 1));
    }

    public static void main(String[] args) {
        System.out.println(getDeletionDistance("some", "thin"));
    }
}
