class Solution
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> tracker = new Stack<Integer>();
        for(String token : tokens)
        {
            if(!(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-") || token.equalsIgnoreCase("*") || token.equalsIgnoreCase("/")))
                tracker.push(Integer.parseInt(token));
            else
            {
                int second = tracker.pop();
                int first = tracker.pop();
                switch(token)
                {
                    case "+":
                        tracker.push(first + second);
                        break;
                    case "-":
                        tracker.push(first - second);
                        break;
                    case "*":
                        tracker.push(first * second);
                        break;
                    case "/":
                        tracker.push(first / second);
                        break;
                }
            }
        }
        return tracker.pop();
    }
}
