class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int slide = 0;
        int count = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while(start < s.length() && slide < s.length()) {
            if(hashSet.contains(s.charAt(slide))) {
                if(s.charAt(slide) != s.charAt(start)) {
                    hashSet.remove(s.charAt(start));
                    count--;
                }
                else{
                    slide++;
                }
                start++;
            }
            else {
                hashSet.add(s.charAt(slide));
                slide++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
