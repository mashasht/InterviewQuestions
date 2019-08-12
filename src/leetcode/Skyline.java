package leetcode;

import java.util.*;
import java.util.stream.Collectors;
// TODO: fix me
public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer, Integer> heights = new HashMap<>();
        for (int i = 0; i < buildings.length; i++) {
            if (heights.containsKey(buildings[i][0])) {
                int previousHeight = heights.get(buildings[i][0]);
                heights.put(buildings[i][0], Math.max(previousHeight, buildings[i][2]));
            }
            else {
                heights.put(buildings[i][0], buildings[i][2]);
            }
            if (heights.containsKey(buildings[i][1])) {
                int previousHeight = heights.get(buildings[i][1]);
                heights.put(buildings[i][1], Math.min(previousHeight, (buildings[i][2] * -1)));
            }
            else {
                heights.put(buildings[i][1], (buildings[i][2] * -1));
            }
        }
        PriorityQueue<Integer> theHighest = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> sortedKeys = heights.keySet().stream().collect(Collectors.toList());
        Collections.sort(sortedKeys);
        List<List<Integer>> result = new LinkedList<>();
        for (int key: sortedKeys) {
            int newHeight = heights.get(key);
            int currentHighest =  theHighest.isEmpty() ? 0 : theHighest.peek();
            if (newHeight > 0) {
                if (newHeight > currentHighest) {
                    List<Integer> newEntry = new LinkedList<>();
                    newEntry.add(key);
                    newEntry.add(newHeight);
                    result.add(newEntry);
                }
                theHighest.add(newHeight);
            }
            else {
                if (Math.abs(newHeight) == currentHighest) {
                    theHighest.poll();
                    List<Integer> newEntry = new LinkedList<>();
                    newEntry.add(key);
                    newEntry.add(theHighest.isEmpty() ? 0 : theHighest.peek());
                    result.add(newEntry);
                }
                else {
                    theHighest.remove(Math.abs(newHeight));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Skyline s = new Skyline();
        int[][] buildings = {{0,2,3}, {2,5,3}};
        //int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(s.getSkyline(buildings));
    }
}
