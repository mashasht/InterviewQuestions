package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PalindromPairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> newEntry = new LinkedList<>();
                    newEntry.add(i);
                    newEntry.add(j);
                    result.add(newEntry);
                }
                if (isPalindrome(words[j] + words[i])) {
                    List<Integer> newEntry = new LinkedList<>();
                    newEntry.add(j);
                    newEntry.add(i);
                    result.add(newEntry);
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s) {
        int middleIndex = s.length()/2;
        String firstHalf = s.substring(0, middleIndex);
        String secondHalf = s.substring(middleIndex + s.length() % 2);
        return firstHalf.equals(new StringBuilder(secondHalf).reverse().toString());
    }
    public static void main(String[] args) {
        String[] words = {"bat","tab","cat"};
        PalindromPairs pp = new PalindromPairs();
        System.out.println(pp.palindromePairs(words));
    }
}
