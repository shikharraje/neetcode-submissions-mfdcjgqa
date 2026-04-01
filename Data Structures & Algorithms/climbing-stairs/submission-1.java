class Solution
{
    int[] dp;

    public int climbStairs(int n)
    {
        this.dp = new int[n + 1];
        Arrays.fill(this.dp, -1);
        this.dp[0] = 0;
        if(n == 0)
            return this.dp[0];
        this.dp[1] = 1;
        if(n == 1)
            return this.dp[1];
        this.dp[2] = 2;
        if(n == 2)
            return this.dp[2];
        return doRecursion(n);
    }

    private int doRecursion(int n)
    {
        if(n < 0)
            return 0;
        else
        {
            if(this.dp[n] != -1)
                return this.dp[n];

            int ifITakeOneStep = doRecursion(n - 1);
            int ifITakeTwoSteps = doRecursion(n - 2);

            this.dp[n] = ifITakeOneStep + ifITakeTwoSteps;
            return this.dp[n];
        }
    }
}
