class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i =0;i < s.length();i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        if(s.length() == 0) return res;
        HashSet<Character> hashSet = new HashSet<>();
        int count = 0;
        for(int i = 0;i < s.length();i++) {
            count++;
            char ch = s.charAt(i);
            hm.put(ch, hm.get(ch) - 1);
            if(!hashSet.contains(ch)) {
                hashSet.add(ch);
            }
            if(hm.get(ch) == 0) {
                hashSet.remove(ch);
                if(hashSet.isEmpty()) {
                    res.add(count);
                    count = 0;
                }
            }
        }
        return res;
    }
}
