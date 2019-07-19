package Pramp;

/**
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols. The function receives two strings
 * - text and pattern - and should return true if the text matches the pattern as a regular expression. For simplicity,
 * assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in
 * the pattern string. In case you aren’t familiar with regular expressions, the function determines if the text and
 * pattern are the equal, where the '.' is treated as a single a character wildcard (see third example), and '*' is
 * matched for a zero or more sequence of the previous letter (see fourth and fifth examples). For more information on
 * regular expression matching, see the Regular Expression Wikipedia page.
 * Explain your algorithm, and analyze its time and space complexities.
 * Examples:
 *
 * input:  text = "aa", pattern = "a"
 * output: false
 *
 * input:  text = "aa", pattern = "aa"
 * output: true
 *
 * input:  text = "abc", pattern = "a.c"
 * output: true
 *
 * input:  text = "abbb", pattern = "ab*"
 * output: true
 *
 * input:  text = "acd", pattern = "ab*c."
 * output: true
 */
public class BasicRegexParser {
    static boolean isMatch(String text, String pattern) {
        return isMatchHelper(text, pattern, 0, 0);
    }
    static boolean isMatchHelper(String text, String pattern, int textIndex, int patternIndex) {
        if (textIndex == text.length()) {
            if (patternIndex == pattern.length()) {
                return true;
            }
            if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {
                return isMatchHelper(text, pattern, textIndex, patternIndex + 2);
            }
            return false;
        }
        if (patternIndex == pattern.length()) {
            return false;
        }
        if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {
            return isMatchHelper(text, pattern, textIndex, patternIndex + 2) ||
                    isMatchHelper(text, pattern, textIndex + 1, patternIndex);
        }
        if (text.charAt(textIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.') {
            return  isMatchHelper(text, pattern, textIndex + 1, patternIndex + 1);
        }
        return false;
    }
    public static void main(String args[]) {
        System.out.println(isMatch("abbbb", "ab*"));
    }
}

/*
'aa', 'a'
textIndex = 0, patternIndex = 0
textIndex = 1, patternIndex = 1

'aa', 'aa'
textIndex = 0, patternIndex = 0

'abc', 'a.c'

'abbb', 'ab*'
textIndex = 0, patternIndex = 0
textIndex = 1, patternIndex = 1

'abaa', 'a.*a*'
textIndex = 0, patternIndex = 0
textIndex = 1, patternIndex = 1
textIndex = 2, patternIndex = 3


 */
