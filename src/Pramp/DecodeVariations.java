package Pramp;
/**
 * A letter can be encoded to a number in the following way:
 * 'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
 * A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'
 * Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.
 *
 * Examples:
 * input:  S = '1262'
 * output: 3
 * explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.
 */
public class DecodeVariations{
    public static int decodeVariations(String s) {
        int[] numOfVariations = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                numOfVariations[i] += 0;
            }
            numOfVariations[i] = getNumOfPreviousVariations(numOfVariations, i - 1);
            if (i - 1 > 0 && Integer.parseInt(s.substring(i - 1, i + 1)) < 27) {
                numOfVariations[i] += getNumOfPreviousVariations(numOfVariations, i - 2);
            }
        }
        return numOfVariations[s.length() - 1];
    }
    private static int getNumOfPreviousVariations(int[] numOfVariations, int index) {
        if (index >= 0 && index <  numOfVariations.length){
            return numOfVariations[index];
        }
        return 1;
    }
}

/*
[0, 0, 0, 0]
[1, 0, 0, 0]
[1, 2, 0, 0]
[1, 2, 3, 3]
*/