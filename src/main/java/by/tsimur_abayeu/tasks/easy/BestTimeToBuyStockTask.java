package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * <p>
 * Time complexity : O(n) | Space complexity : O(1)
 * <p>
 * It's important to remember that we only need some value and not approach it from the beginning as trying to find max
 * among all possible permutations.
 * <p>
 * Two keys : 1) we can shift min index to the next value and forget about previous state - if selling point is ahead of
 * us profit based on new min is for sure bigger;
 * <p>
 * 2) we don't need indices of days or secondary (in terms of profit) pairs of days to be stored. So single variable
 * caching current maxProfit is the only thing that we need.
 */
public class BestTimeToBuyStockTask implements Task {

    @Override
    public Object solve(Object... args) {
        return maxProfit((int[]) args[0]);
    }

    public int maxProfit(int[] prices) {
        int currentMinIndex = 0;
        int maxProfit = 0;
        int currentValue = 0;
        int currentProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            currentValue = prices[i];
            currentProfit = currentValue - prices[currentMinIndex];
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            if (currentValue < prices[currentMinIndex]) {
                currentMinIndex = i;
            }
        }
        return maxProfit;
    }
}