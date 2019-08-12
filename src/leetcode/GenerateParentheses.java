package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> pars = new LinkedList<>();
        recursiveParenthesesGenerator(pars, n, 0, "");
        return pars;
    }
    private void recursiveParenthesesGenerator(List<String> pars, int n, int openingCounter, String intermediateRes){
        if (intermediateRes.length() / 2 == n) {
            pars.add(intermediateRes);
        }
        if (openingCounter > 0) {
            int newOpeningCounter = openingCounter - 1;
            recursiveParenthesesGenerator(pars, n, newOpeningCounter, intermediateRes + ")");
        }
        if (openingCounter < (n * 2 - intermediateRes.length() - 1)) {
            int newOpeningCounter = openingCounter + 1;
            recursiveParenthesesGenerator(pars, n, newOpeningCounter, intermediateRes + "(");
        }
    }
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
