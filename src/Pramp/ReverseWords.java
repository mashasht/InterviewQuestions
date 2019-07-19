package Pramp;

/**
 * Created by mashashtutman on 2019-07-03.
 * You are given an array of characters arr that consists of sequences of characters separated by space characters.
 * Each space-delimited sequence of characters defines a word.
 * Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.
 * Explain your solution and analyze its time and space complexities.

 Example:

 input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
 'm', 'a', 'k', 'e', 's', '  ',
 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

 output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
 'm', 'a', 'k', 'e', 's', '  ',
 'p', 'e', 'r', 'f', 'e', 'c', 't
 */
public class ReverseWords {
    static char[] reverseWords(char[] arr) {
        reverseAll(arr, 0, arr.length);
        int startWord = 0;
        int endWord = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                endWord = i;
            }
            reverseAll(arr, startWord, endWord);
            startWord = endWord + 1;
        }
        return arr;
    }
    static void reverseAll(char[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex/2; i++) {
            char temp = arr[endIndex - i - 1];
            arr[endIndex - i - 1] = arr[i];
            arr[i] = temp;
        }
    }
}
