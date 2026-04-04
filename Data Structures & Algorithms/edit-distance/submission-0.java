class Solution {
    String word1;
    String word2;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        int n = word1.length();
        int m = word2.length();
        int res = helper(0, 0);
        return res == Integer.MAX_VALUE? -1 : res;
    }

    int helper(int i, int j) {
        if(j == word2.length()) return word1.length() - i;
        if(i == word1.length()) return word2.length() - j;

        if(word1.charAt(i) == word2.charAt(j)) {
            return helper(i + 1, j + 1);
        }
        
        int res = helper(i + 1, j + 1);
        res = Math.min(res, helper(i + 1, j));
        res = Math.min(res, helper(i, j + 1));
    
        return 1 + res;
    }
}
