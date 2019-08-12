package leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {

    /*
    [4,3,2,7,8,2,3,1]
    [7,3,2,4,8,2,3,1]
    [3,3,2,4,8,2,7,1]
    [2,3,3,4,8,2,7,1]
    [3,2,3,4,8,2,7,1]
    [-1,2,3,4,8,2,7,1]
    [-1,2,3,4,1,2,7,8]
    [1,2,3,4,-1,2,7,8]
    [1,2,3,4,-1,-1,7,8]
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentIndex = i;
            while (currentNum != -1 && currentNum != currentIndex + 1) {
                if (nums[currentNum - 1] == currentNum) {
                    nums[currentIndex] = -1;
                    break;
                }
                swap(nums, currentIndex, currentNum - 1);
                currentNum = nums[currentIndex];
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                result.add(i + 1);
            }
        }
        return result;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void main(String[] args) {
        FindDisappearedNumbers fdn = new FindDisappearedNumbers();
        int[] input = {4,3,2,7,8,2,3,1};
        System.out.println(fdn.findDisappearedNumbers(input));
    }
}
