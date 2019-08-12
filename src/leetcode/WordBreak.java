package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        wordDictSet.addAll(wordDict);
        return wordBreakHelper(s, wordDictSet, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> wordDictSet, int index) {
        if (index == s.length()) {
            return true;
        }
        for (String word: wordDictSet) {
            if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                if (wordBreakHelper(s, wordDictSet, index + word.length())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("catsandog", wordDict));
    }
}
