class Solution
{
    int[] dp;

    int[] cost;

    public int minCostClimbingStairs(int[] cost)
    {
        this.cost = cost;
        this.dp = new int[cost.length];
        Arrays.fill(this.dp, -1);
        this.dp[0] = cost[0];
        if(cost.length == 1)
            return this.dp[0];
        this.dp[1] = cost[1];
        return Math.min(doRecursion(cost.length - 1), doRecursion(cost.length - 2));
    }

    private int doRecursion(int n)
    {
        if(n < 0)
            return 0;
        else
        {
            if(this.dp[n] != -1)
                return this.dp[n];

            int ifIComeFromNMinus1 = doRecursion(n - 1);
            int ifIComeFromNMinus2 = doRecursion(n - 2);

            this.dp[n] = Math.min(ifIComeFromNMinus1, ifIComeFromNMinus2) + this.cost[n];
            return this.dp[n];
        }
    }
}
