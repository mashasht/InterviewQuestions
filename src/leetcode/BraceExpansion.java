package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BraceExpansion {

    public String[] expand(String S) {
        Set<String> result = new HashSet<>();
        result = recursiveExpand(S, "", result);
        String[] resultArr = result.stream().toArray(String[]::new);
        return resultArr;
    }
    public Set<String> recursiveExpand(String remaining, String constructed, Set<String> result) {
        int openingBracketIndex = remaining.indexOf("{");
        if (openingBracketIndex == -1) {
            result.add(constructed + remaining);
            return result;
        }
        int closingBracketIndex = remaining.indexOf("}");
        String charsToExpand = remaining.substring(openingBracketIndex + 1, closingBracketIndex);
        String[] charsArr = charsToExpand.split(",");
        for (int i = 0; i < charsArr.length; i++) {
            String newConstructed = constructed + remaining.substring(0, openingBracketIndex) +
                    charsArr[i];
            recursiveExpand(remaining.substring(closingBracketIndex + 1), newConstructed,
                    result);
        }
        return result;
    }
    public static void main (String[] args) {
        BraceExpansion be = new BraceExpansion();
        String[] result = be.expand("{a,b,c}d{e,f}");
        for (String s: result) {
            System.out.println(s);
        }
    }
}
