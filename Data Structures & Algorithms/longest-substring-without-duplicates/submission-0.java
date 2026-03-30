class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int left = 0;
        int right = 0;
        HashSet<Character> seen = new HashSet<Character>();
        int res = seen.size();
        while(right < s.length())
        {
            if(seen.contains(s.charAt(right)))
            {
                while(seen.contains(s.charAt(right)))
                {
                    seen.remove(s.charAt(left));
                    left++;
                }
            }
            seen.add(s.charAt(right));
            right++;
            res = Math.max(res, seen.size());
        }
        return res;
    }
}
