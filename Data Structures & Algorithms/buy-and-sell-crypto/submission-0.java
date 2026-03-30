class Solution
{
    public int maxProfit(int[] prices)
    {
        int rightMostGreatest = prices.length - 1;
        int leftSlider = prices.length - 1;
        int res = 0;
        while(leftSlider >= 0)
        {
            res = Math.max(res, prices[rightMostGreatest] - prices[leftSlider]);
            // Slide left, expand the window
            leftSlider--;
            // Contract window if applicable
            if(leftSlider >=0 && prices[leftSlider] > prices[rightMostGreatest])
            {
                rightMostGreatest = leftSlider;
            }
        }
        return res;
    }
}
