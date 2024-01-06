package easy.bestTimeToBuyAndSell;

public class Solution {

    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;
        int maxProfit = 0;
        while(end < prices.length){
            if(prices[start] < prices[end]){
                maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
            }else{
                start = end;
            }
            end++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2}));
    }
}
