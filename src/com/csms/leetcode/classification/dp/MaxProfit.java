package com.csms.leetcode.classification.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int max = 0;
        int i =0 ,j = 1;
        int low = -1;
        int high = -1;
        while(j < prices.length){
            if(prices[j] <= prices[i]){
                if(low != -1){
                    high = i;
                    max += prices[high] - prices[low];
                    low = -1;
                    high = -1;

                }
            }else{
                if(low == -1) {
                    low = i;
                }
            }
            j++;
            i++;
        }
        if(low != -1){
            max += prices[prices.length - 1] - prices[low];
        }
        return max;
    }

    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
