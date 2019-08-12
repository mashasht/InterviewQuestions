package InterviewCake;

public class CakeOrderChecker {
    public static boolean checkCakeOrders(int[] takeOut, int[] dineIn, int[] servedOrders) {
        int takeOutIndex = 0;
        int dineInIndex = 0;
        if (servedOrders.length != dineIn.length + takeOut.length) {
            return false;
        }
        for (int order: servedOrders) {
            if (dineInIndex < dineIn.length && order == dineIn[dineInIndex]) {
                dineInIndex++;
                continue;
            }
            if (takeOutIndex < takeOut.length && order == takeOut[takeOutIndex]) {
                takeOutIndex++;
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        int[] takeOut = {1, 15, 87, 3, 21};
        int[] dineIn = {16, 76, 32};
        int[] served = {16, 76, 21, 1, 15, 87, 3, 32};
        System.out.println(checkCakeOrders(takeOut, dineIn, served));
    }
}
