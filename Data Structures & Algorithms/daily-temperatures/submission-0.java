class Solution
{
    public int[] dailyTemperatures(int[] temperatures)
    {
        Stack<Pair> tracker = new Stack<Pair>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++)
        {
            if(tracker.isEmpty() || tracker.peek().temperature >= temperatures[i])
                tracker.push(new Pair(i, temperatures[i]));
            else
            {
                while(!tracker.isEmpty() && tracker.peek().temperature < temperatures[i])
                {
                    Pair top = tracker.pop();
                    result[top.index] = i - top.index;
                }
                tracker.push(new Pair(i, temperatures[i]));
            }
        }
        while(!tracker.isEmpty())
            result[tracker.pop().index] = 0;
        return result;
    }
}

class Pair
{
    private final int index;

    private final int temperature;

    public Pair(int i, int t)
    {
        this.index = i;
        this.temperature = t;
    }
}