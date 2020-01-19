package dev.algos.snatch.interview_problems.gss;

class BestTimeToBuyStock {
    int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else if (profit < prices[i] - buyPrice) {
                profit = prices[i] - buyPrice;
            }
        }
        return profit;
    }
}
