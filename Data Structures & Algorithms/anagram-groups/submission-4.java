class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> myList = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        for(int i = 0;i<strs.length;i++){
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            for (char c : strs[i].toCharArray()) {
                if(hm.containsKey(c)){
                    hm.put(c,hm.get(c)+1);
                }
                else{
                    hm.put(c,1);
                }
            }
            ArrayList<String> strStr = new ArrayList<String>();
            if(myList.containsKey(hm)){
               strStr=myList.get(hm);
            }
            strStr.add(strs[i]);
            myList.put(hm, strStr);
        }
        List<List<String>> values = new ArrayList<List<String>>(myList.values());
    return values;
    }
}
