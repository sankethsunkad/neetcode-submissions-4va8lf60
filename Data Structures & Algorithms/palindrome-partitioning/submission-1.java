class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(0, s, new ArrayList<>());
        return res;
    }

    public void helper(int index, String s, List<String> list) {
        if(index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < s.length();i++) {
            String sub = s.substring(index, i + 1);
            if(isPalindrome(sub)) {
                list.add(sub);
                helper(i + 1, s, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
