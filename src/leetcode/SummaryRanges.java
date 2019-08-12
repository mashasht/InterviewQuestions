package leetcode;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    //[0,1,2,4,5,7]
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            // 0
            int startRange = nums[i];
            int endRange = startRange;
            while (i < nums.length && nums[i] == endRange) {
                endRange++;
                i++;
            }
            if (startRange != nums[i - 1]) {
                result.add(startRange + "->" + nums[i - 1]);
            }
            else {
                result.add(nums[i - 1] + "");
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        SummaryRanges sr = new SummaryRanges();
        System.out.println(sr.summaryRanges(nums));
    }
}
