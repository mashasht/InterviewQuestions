package leetcode;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] next = new int[71];
        int[] result = new int[T.length];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
        }
        for (int i = T.length - 1; i >= 0; i--) {
            // next[43] = 7
            // next[46] = 6
            // next[42] = 5
           next[T[i] - 30] = i;
           int min = 1000;
           for (int j = T[i] - 30 + 1 ; j < next.length; j++) {
               if (next[j] != -1) {
                   min = Math.min(min, next[j] - i);
               }
           }
           // result[7] = 0
           // result[6] = 0

           if (min == 1000) {
               result[i] = 0;
           }
           else {
               result[i] = min;
           }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dt = new DailyTemperatures();
        int[] result = dt.dailyTemperatures(T);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
