class Solution {

    private final String delimiter = "\uE000";

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return null;
        StringBuilder encodedRes = new StringBuilder();
        for(int i = 0; i < (strs.size() - 1); i++)
        {
            encodedRes.append(strs.get(i));
            encodedRes.append(delimiter);
        }
        encodedRes.append(strs.get(strs.size() - 1));
        return encodedRes.toString();
    }

    public List<String> decode(String str)
    {
        if(str == null)
            return new ArrayList<String>();
        String[] splitStrings = str.split(delimiter);
        return new ArrayList<String>(Arrays.asList(splitStrings));
    }
}
