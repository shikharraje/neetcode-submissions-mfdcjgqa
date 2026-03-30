class Solution
{
    public boolean hasDuplicate(int[] nums)
    {
        HashSet<Integer> tracker = new HashSet<Integer>();
        for(int num : nums)
        {
            if(tracker.contains(num))
                return true;
            tracker.add(num);
        }
        return false;
    }
}
