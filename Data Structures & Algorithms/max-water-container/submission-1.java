class Solution
{
    public int maxArea(int[] heights)
    {
        int left = 0;
        int right = heights.length - 1;

        int res = Integer.MIN_VALUE;

        while(right > left)
        {
            int currentArea = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(res, currentArea);

            if(heights[left] < heights[right])
                left++;
            else if(heights[right] < heights[left])
                right--;
            else
            {
                left++;
                right--;
            }
        }

        return res;
    }
}
