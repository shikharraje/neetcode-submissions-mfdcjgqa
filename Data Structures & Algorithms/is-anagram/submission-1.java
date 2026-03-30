class Solution
{
    public boolean isAnagram(String s, String t)
    {
        int[] characterCounter = new int[26];
        for(int i = 0; i < s.length(); i++)
            characterCounter[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++)
            characterCounter[t.charAt(i) - 'a']--;
        for(int i = 0; i < 26; i++)
        {
            if(characterCounter[i] != 0)
                return false;
        }
        return true;
    }
}
