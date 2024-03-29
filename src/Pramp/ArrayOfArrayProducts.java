package Pramp;

/**
 * Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.
 * Solve without using division and analyze your solution’s time and space complexities.
 * Examples:
 * input:  arr = [8, 10, 2]
 * output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]
 * input:  arr = [2, 7, 3, 4]
 * output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]
 * Created by mashashtutman on 2019-07-05.
 */
public class ArrayOfArrayProducts {
    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new int[0];
        }
        int[] forwards = new int[arr.length];
        int[] backwards = new int[arr.length];
        int[] result = new int[arr.length];
        forwards[0] = 1;
        backwards[arr.length - 1] = 1;
        // [8, 10, 2]
        // [1, 8, 80]
        for (int i = 1; i < arr.length; i++) {
            forwards[i] = forwards[i - 1] * arr[i - 1];
        }
        // [20, 2, 1]
        for (int j = arr.length - 2; j >= 0; j--) {
            backwards[j] = backwards[j + 1] * arr[j + 1];
        }
        // [20, 16, 80]
        for (int k = 0; k < arr.length; k++) {
            result[k] = forwards[k] * backwards[k];
        }
        return result;
    }
}
