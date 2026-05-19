class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(0, 0, new StringBuilder(), n);
        return res;
    }

    void helper(int open, int close, StringBuilder s, int n) {
        if (open == n && close == n) {
            res.add(s.toString());
            return;
        }

        if (open < n) {
            s.append("(");
            helper(open + 1, close, s, n);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(")");
            helper(open, close + 1, s, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}