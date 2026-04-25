class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        int curr = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while(i < n && j < n) {
            curr = j - i;
            if(!hashSet.contains(s.charAt(j))) {
                curr++;
                res = Math.max(res, curr);
                hashSet.add(s.charAt(j));
                j++;
            }
            else {
                while(s.charAt(i) != s.charAt(j)) {
                    hashSet.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
