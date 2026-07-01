class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> lastIndex = new HashMap<>();

        for(int i = 0;i < s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        int last = 0;
        int count = 0;
        for(int i = 0;i < s.length();i++) {
            last = Math.max(last, lastIndex.get(s.charAt(i)));
            count++;
            if(i == last) {
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}
