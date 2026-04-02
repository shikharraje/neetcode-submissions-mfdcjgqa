class Solution
{
    int[] nums;

    int[] dp;

    public int rob(int[] nums)
    {
        this.nums = nums;
        this.dp = new int[nums.length];
        Arrays.fill(this.dp, -1);
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if(nums.length == 3)
            return Math.max(nums[1], nums[0] + nums[2]);

        this.dp[0] = nums[0];
        this.dp[1] = Math.max(nums[0], nums[1]);
        this.dp[2] = Math.max(nums[1], nums[0] + nums[2]);

        int profitIfIRobLastHouse = nums[nums.length - 1] + doRecursion(nums.length - 3);
        int profitIfIRobSecondLastHouse = nums[nums.length - 2] + doRecursion(nums.length - 4);

        return Math.max(profitIfIRobLastHouse, profitIfIRobSecondLastHouse);
    }

    private int doRecursion(int currentIndex)
    {
        if(currentIndex < 0)
            return 0;
        if(currentIndex == 0)
            return this.nums[0];
        if(currentIndex == 1)
            return Math.max(this.nums[0], this.nums[1]);
        if(currentIndex == 2)
            return Math.max(this.nums[1], this.nums[0] + this.nums[2]);


        if(this.dp[currentIndex] != -1)
            return this.dp[currentIndex];
        
        int profitIfIRobCurrentMinus1 = doRecursion(currentIndex - 1);
        int profitIfIRobCurrentMinus2 = nums[currentIndex] + doRecursion(currentIndex - 2);


        this.dp[currentIndex] = Math.max(profitIfIRobCurrentMinus1, profitIfIRobCurrentMinus2);
        return this.dp[currentIndex];
    }
}
