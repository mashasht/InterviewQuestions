package InterviewCake;

import java.util.HashSet;
import java.util.Set;

public class AllStringPermutations {
    public static Set<String> returnAllPermutations(String str) {
        return recursivePermutations(str, new HashSet<>(), "");
    }
    private static Set<String> recursivePermutations(String remaining, Set<String> result,
                                                     String intermediate) {
        if (remaining.length() == 0) {
            result.add(intermediate);
            return result;
        }
        for (int i = 0; i < remaining.length(); i++) {
            String newIntermediate = intermediate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            recursivePermutations(newRemaining, result, newIntermediate);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(returnAllPermutations("cat"));
    }
}
