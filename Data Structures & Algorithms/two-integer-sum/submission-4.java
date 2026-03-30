class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, ArrayList<Integer>> numToLocationMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!numToLocationMap.containsKey(nums[i]))
                numToLocationMap.put(nums[i], new ArrayList<Integer>());
            numToLocationMap.get(nums[i]).add(i);
        }
        for(int i = 0; i < nums.length; i++)
        {
            int leftoverTarget = target - nums[i];
            if(leftoverTarget == nums[i])
            {
                if(numToLocationMap.get(nums[i]).size() > 1)
                    return new int[]{numToLocationMap.get(nums[i]).get(0), numToLocationMap.get(nums[i]).get(1)};
            }
            else
            {
                if(numToLocationMap.containsKey(leftoverTarget))
                    return new int[]{numToLocationMap.get(nums[i]).get(0), numToLocationMap.get(leftoverTarget).get(0)};
            }
        }
        return new int[2];
    }
}
