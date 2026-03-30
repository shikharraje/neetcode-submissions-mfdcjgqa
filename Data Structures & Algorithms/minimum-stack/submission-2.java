class MinStack
{
    private final int[] minStack;
    private final int[] actualStack;
    private int tracker;
    
    public MinStack()
    {
        this.tracker = 0;
        this.minStack = new int[100_001];
        this.actualStack = new int[100_001];
    }
    
    public void push(int val)
    {
        this.actualStack[tracker] = val;
        if(tracker == 0 || this.minStack[tracker - 1] >= val)
            this.minStack[tracker] = val;
        else
            this.minStack[tracker] = this.minStack[tracker - 1];
        tracker++;
    }
    
    public void pop()
    {
        tracker--;
    }
    
    public int top() {
        return this.actualStack[tracker - 1];
    }
    
    public int getMin() {
        return this.minStack[tracker - 1];
    }
}
