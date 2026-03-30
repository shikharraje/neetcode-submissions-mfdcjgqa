class Solution
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[')
                stack.push(current);
            else
            {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(current == ')' && top == '(')
                    continue;
                else if(current == '}' && top == '{')
                    continue;
                else if(current == ']' && top == '[')
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
