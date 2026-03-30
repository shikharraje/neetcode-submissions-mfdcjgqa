class Solution
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens)
        {
            if(!token.equalsIgnoreCase("+") && !token.equalsIgnoreCase("-") && !token.equalsIgnoreCase("*") && !token.equalsIgnoreCase("/"))
                stack.push(Integer.parseInt(token));
            else
            {
                int second = stack.pop();
                int first = stack.pop();
                if(token.equalsIgnoreCase("+"))
                    stack.push(first + second);
                else if(token.equalsIgnoreCase("-"))
                    stack.push(first - second);
                else if(token.equalsIgnoreCase("*"))
                    stack.push(first * second);
                else
                    stack.push(first / second);
            }
        }
        return stack.pop();
    }
}
