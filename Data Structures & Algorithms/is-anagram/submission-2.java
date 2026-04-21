class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charInput = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0;i < s.length();i++) {
            charInput[s.charAt(i) - 'a']++;
            charInput[t.charAt(i) - 'a']--;
        }
        for(int val : charInput) {
            if(val != 0) return false;
        }
        return true;
    }
}
