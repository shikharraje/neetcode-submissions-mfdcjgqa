class Solution
{
    public List<List<Integer>> subsets(int[] nums)
    {
        return doBacktracking(nums, 0);
    }

    private List<List<Integer>> doBacktracking(int[] nums, int index)
    {
        if(index == nums.length - 1)
        {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[index]);
            result.add(temp);

            return result;
        }
        else
        {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<List<Integer>> otherElements = doBacktracking(nums, index + 1);
            for(List<Integer> subset : otherElements)
            {
                List<Integer> withElement = new ArrayList<Integer>(subset);
                withElement.add(nums[index]);
                result.add(withElement);
                result.add(subset);
            }
        return result;
        }
    }
}
