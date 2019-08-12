package leetcode;

public class FindUniqueCharacters {
    public int firstUniqChar(String s) {
        int aNumValue = 'a';
        int[] alphabet = new int['z' - aNumValue + 1];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - aNumValue]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - aNumValue] == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindUniqueCharacters fuc = new FindUniqueCharacters();
        System.out.println(fuc.firstUniqChar("loveleetcode"));
    }
}
