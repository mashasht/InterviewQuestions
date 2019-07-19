package Pramp;

import java.util.Arrays;


/**
 * Created by mashashtutman on 2019-06-15.
 *
 * Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array
 * of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending
 * order.
 * Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space
 * complexities of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger
 * than arr1.

 Example:

 input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]

 output: [3, 6, 7] # since only these three
 */
public class FindDuplicates {
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        int[] duplicates = new int[Math.min(arr1.length, arr2.length)];
        int index = 0;
        for (int i= 0, j = 0; i < arr1.length && j < arr2.length;){
            if (arr1[i] < arr2[j]) {
                i++;
                continue;
            }
            if (arr1[i] > arr2[j]) {
                j++;
                continue;
            }
            duplicates[index] = arr1[i];
            i++;
            j++;
            index++;
        }
        int[] result =  Arrays.copyOfRange(duplicates, 0, index);
        return result;
    }
}
/*
[0, 2, 3, 5, 6, 7, 10]
[1, 3, 8, 10]


0, 1
1, 2
2, 3
3, 3
[3,,,]
5, 8
6, 8
7, 8
10, 8
10, 10
[3, 10,,]
 */