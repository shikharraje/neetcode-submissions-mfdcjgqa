class Solution
{
    public int[] twoSum(int[] numbers, int target)
    {
        int right = numbers.length - 1;
        int left = 0;
        while(right > left && left >= 0 && left < numbers.length && right >= 0 && right < numbers.length)
        {
            int current = numbers[left] + numbers[right];
            if(target == current)
                return new int[]{left + 1, right + 1};
            else if(target > current)
                left++;
            else
                right--;
        }
        return new int[]{-1, -1};
    }
}
