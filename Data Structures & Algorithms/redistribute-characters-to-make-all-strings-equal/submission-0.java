class Solution {
    public boolean makeEqual(String[] words) {
        int[] overall = new int[26];
        for(int i = 0;i < words.length;i++) {
            String str = words[i];
            for(int j = 0;j < str.length();j++) {
                overall[str.charAt(j) - 'a']++;
            }
        }

        int n = words.length;
        for(int i = 0;i < 26;i++) {
            if(overall[i] % n != 0) return false;
        }
        return true;
    }
}