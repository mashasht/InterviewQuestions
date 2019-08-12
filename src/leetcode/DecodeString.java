package leetcode;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder solution = new StringBuilder();
        decodeHelper(s, 0, solution);
        return solution.toString();
    }
    // "3[a]2[bc]", 0, ""
    private int decodeHelper(String s, int index, StringBuilder solution) {
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int start = index;
                while (Character.isDigit(s.charAt(index++)));
                int times = Integer.parseInt(s.substring(start, index - 1));
                int newIndex = index;
                for (int i = 0; i < times; i++) {
                    newIndex = decodeHelper(s, index, solution);
                }
                index = newIndex + 1;
            }
            while (index < s.length() && !Character.isDigit(s.charAt(index)) && s.charAt(index) != ']') {
                solution.append(s.charAt(index++));
            }
            if (index == s.length() || s.charAt(index) == ']') {
                return index;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("22[abc]"));
    }
}
