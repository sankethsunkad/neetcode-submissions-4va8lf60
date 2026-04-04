class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return res;
    }
    void helper(String s, int index, List<String> str) {
        if(index == s.length()) {
            res.add(new ArrayList<>(str));
            return;
        }
        for(int i = index;i < s.length();i++) {
            String sub = s.substring(index, i + 1);
            if(isPalindrome(sub)) {
                str.add(sub);
                helper(s, i + 1, str);
                str.remove(str.size() - 1);
            }
        }
        return;
    }
    boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(j > 0 && i < (str.length() - 1 ) && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        } 
        while(i >= j) return true;
        return false;
    }
}
