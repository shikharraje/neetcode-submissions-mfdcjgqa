class Solution
{
    public boolean isAnagram(String s, String r)
    {
        int[] sArray = track(s);
        int[] rArray = track(r);
        for(int i = 0; i < 26; i++)
        {
            if(sArray[i] != rArray[i])
                return false;
        }
        return true;
    }

    private int[] track(String x)
    {
        int[] res = new int[26];
        for(int i = 0; i < x.length(); i++)
            res[x.charAt(i) - 'a']++;
        return res;
    }
}
