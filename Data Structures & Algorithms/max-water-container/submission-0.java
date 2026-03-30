class Solution
{
    public int maxArea(int[] heights)
    {
        int left = 0;
        int right = heights.length - 1;
        int result = Integer.MIN_VALUE;
        while(left < right)
        {
            int candidate = Math.min(heights[left], heights[right]);
            candidate *= (Math.abs(right - left));
            result = Math.max(result, candidate);
            if(heights[left] < heights[right])
                left++;
            else if(heights[left] > heights[right])
                right--;
            else
            {
                left++;
                right--;
            }
        }
        return result;
    }
}
