class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, ArrayList<Integer>> reverseIndex = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!reverseIndex.containsKey(nums[i]))
                reverseIndex.put(nums[i], new ArrayList<Integer>());
            reverseIndex.get(nums[i]).add(i);
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : reverseIndex.entrySet())
        {
            int remainder = target - entry.getKey();
            if(reverseIndex.containsKey(remainder))
            {
            if(remainder == entry.getKey())
            {
                res[0] = Math.min(entry.getValue().get(0), entry.getValue().get(1));
                res[1] = Math.max(entry.getValue().get(0), entry.getValue().get(1));
                return res;
            }
            else
            {
                res[0] = Math.min(entry.getValue().get(0), reverseIndex.get(remainder).get(0));
                res[1] = Math.max(entry.getValue().get(0), reverseIndex.get(remainder).get(0));
                return res;
            }
            }
        }
        return new int[] {-1, -1};
    }
}
