package Pramp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mashashtutman on 2019-07-03.
 *
 * Given two words source and target, and a list of words words, find the length of the shortest series of edits that
 * transforms source to target.
 * Each edit must change exactly one letter at a time, and each intermediate word (and the final target word) must exist
 * in words.
 *
 * If the task is impossible, return -1.
 *
 Examples:

 source = "bit", target = "dog"
 words = ["but", "put", "big", "pot", "pog", "dog", "lot"]

 output: 5
 explanation: bit -> but -> put -> pot -> pog -> dog has 5 transitions.
 source = "no", target = "go"
 words = ["to"]

 output: -1
 */
public class ShortestWordEditPath {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static int shortestWordEditPath(String source, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> counter = new LinkedList<>();
        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
        queue.add(source);
        counter.add(1);
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentCounter = counter.poll();
            visited.add(currentWord);
            Set<String> wordsAdjacent = returnAdjacentWords2(currentWord, wordsSet);
            if (wordsAdjacent.contains(target)) {
                return currentCounter;
            }
            wordsAdjacent.removeAll(visited);
            queue.addAll(wordsAdjacent);
            currentCounter++;
            for (int i = 0; i < wordsAdjacent.size(); i++) {
                counter.add(currentCounter);
            }
        }
        return -1;
    }

    static Set<String> returnAdjacentWords(String currentWord, String[] words){
        Set<String> result = new HashSet<>();
        int matchCounter;
        for (String word: words) {
            matchCounter = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == currentWord.charAt(i)) {
                    matchCounter++;
                }
            }
            if (matchCounter == currentWord.length() - 1) {
                result.add(word);
            }
        }
        return result;
    }

    static Set<String> returnAdjacentWords2(String currentWord, Set<String> wordsSet){
        Set<String> result = new HashSet<>();
        for (int i = 0; i < currentWord.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                String constructedWord = currentWord.substring(0, i) + alphabet.charAt(j) +
                        currentWord.substring(i + 1, currentWord.length());
                if (wordsSet.contains(constructedWord)) {
                    result.add(constructedWord);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"but", "put"};
        System.out.println(shortestWordEditPath("bit", "put", words));
    }
}
/*
bit - but, big
 */
