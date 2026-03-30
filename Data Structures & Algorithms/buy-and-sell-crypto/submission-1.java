class Solution
{
    public int maxProfit(int[] prices)
    {
        int res = 0;
        int[] largestPriceToTheRight = new int[prices.length];
        largestPriceToTheRight[largestPriceToTheRight.length - 1] = prices[prices.length - 1];
        for(int i = largestPriceToTheRight.length - 2; i >= 0; i--)
            largestPriceToTheRight[i] = Math.max(largestPriceToTheRight[i + 1], prices[i]);
        for(int i = 0; i < prices.length; i++)
        {
            int gain = largestPriceToTheRight[i] - prices[i];
            res = Math.max(res, gain);
        }
        return res;
    }
}
