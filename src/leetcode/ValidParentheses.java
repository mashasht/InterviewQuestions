package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> openingPar = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                openingPar.push(currentChar);
                continue;
            }
            if (!checkMatchingBracket(currentChar, openingPar, '{', '}') ||
                    !checkMatchingBracket(currentChar, openingPar, '(', ')') ||
                    !checkMatchingBracket(currentChar, openingPar, '[', ']')) {
                return false;
            }
        }
        if (!openingPar.empty()) {
            return false;
        }
        return true;
    }
    private boolean checkMatchingBracket(char currentChar, Stack<Character> openingPar, char opening, char closing){
        if (currentChar == closing) {
            if (openingPar.empty()) {
                return false;
            }
            if (openingPar.pop() != opening) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("]"));
    }
}
