class MinStack {

    Stack<Integer> mainStack;

    Stack<Integer> getMinStack;

    public MinStack() {
        this.mainStack = new Stack<Integer>();
        this.getMinStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.mainStack.push(val);
        if(this.getMinStack.isEmpty() || this.getMinStack.peek() >= val)
            this.getMinStack.push(val);
    }
    
    public void pop() {
        int temp = this.mainStack.pop();
        if(temp == this.getMinStack.peek())
            this.getMinStack.pop();
    }
    
    public int top() {
        return this.mainStack.peek();
    }
    
    public int getMin() {
        return this.getMinStack.peek();
    }
}
