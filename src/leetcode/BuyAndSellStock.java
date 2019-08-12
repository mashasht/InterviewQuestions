package leetcode;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int len = prices.length;
        int[] cache = new int[len + 2];
        for (int d = len - 2; d >= 0; d--) {
            int minprice = prices[d];
            int profit = 0;
            for (int x = d; x < len; x++) {
                minprice = Math.min(minprice, prices[x]);
                profit = Math.max(profit, prices[x] - minprice + cache[x + 2]);
            }
            cache[d] = profit;
        }
        return cache[0];
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        BuyAndSellStock bs = new BuyAndSellStock();
        System.out.println(bs.maxProfit(prices));
    }
}
