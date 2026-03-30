class Solution
{
    public int[] twoSum(int[] numbers, int target)
    {
        int res[] = new int[]{-1, -1};
        int left = 0;
        int right = numbers.length - 1;
        while(left < right)
        {
            int candidate = numbers[left] + numbers[right];
            if(candidate == target)
            {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            else if(candidate < target)
            {
                left++;
            }
            else if(candidate > target)
            {
                right--;
            }
        }
        return res;
    }
}
