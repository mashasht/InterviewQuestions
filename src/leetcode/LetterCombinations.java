package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashashtutman on 2019-05-28.
 */
public class LetterCombinations {
    String[] mappings = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"

    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        return letterCombinationsRecursive(digits, result, "", 0);
    }
    public List<String> letterCombinationsRecursive(String digits, List<String> result, String current, int index) {
       if (index == digits.length()) {
            result.add(current);
            return result;
        }
        int currentDigit = digits.charAt(index) - '0';
        for (int i = 0; i < mappings[currentDigit].length(); i++) {
            letterCombinationsRecursive(digits, result, current + mappings[currentDigit].charAt(i), index + 1);
        }
        return result;
    }
    public static void main(String[] args){
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }

}
