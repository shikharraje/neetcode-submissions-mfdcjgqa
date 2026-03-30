class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String, List<String>> tracker = new HashMap<String, List<String>>();
        for(String str : strs)
        {
            System.out.println("Working with: " + str);
            String sortedString = sortify(str);
            System.out.println("Sorted: " + sortedString);
            if(!tracker.containsKey(sortedString))
                tracker.put(sortedString, new ArrayList<String>());
            tracker.get(sortedString).add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> value : tracker.values())
            res.add(value);
        return res;
    }

    private String sortify(String x)
    {
        int[] tracker = new int[26];
        for(int i = 0; i < x.length(); i++)
            tracker[x.charAt(i) - 'a']++;
        System.out.println("Tracker afer hashing: " + Arrays.toString(tracker));
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 26; i++)
        {
            char temp = (char)(i + 'a');
            for(int j = 0; j < tracker[i]; j++)
            {
                System.out.println("Appending: " + temp);
                res.append(temp);
            }
        }
        System.out.println("Current res: " + res.toString());
        return res.toString();
    }
}
