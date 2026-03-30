class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<List<Integer>, List<String>> encodedStringToPositionsMap = new HashMap<List<Integer>, List<String>>();
        for(String str : strs)
        {
            ArrayList<Integer> encodedString = encodeToSize26ArrayList(str);
            if(!encodedStringToPositionsMap.containsKey(encodedString))
                encodedStringToPositionsMap.put(encodedString, new ArrayList<String>());
            encodedStringToPositionsMap.get(encodedString).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<Integer> encodedString : encodedStringToPositionsMap.keySet())
            res.add(encodedStringToPositionsMap.get(encodedString));
        return res;
    }

    private ArrayList<Integer> encodeToSize26ArrayList(String s)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < 26; i++)
            res.add(0);
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            res.set(idx, res.get(idx) + 1);
        }
        return res;
    }
}
