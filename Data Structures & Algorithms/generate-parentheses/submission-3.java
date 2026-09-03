class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n, n, new StringBuilder());
        return res;
    }

    void helper(int open, int close, StringBuilder str) {
        if(open == 0 && close == 0) {
            res.add(str.toString());
            return;
        }

        if(open > 0) {
            str.append("(");
            helper(open - 1, close, str);
            str.deleteCharAt(str.length() - 1);
        }

        if(close > open) {
            str.append(")");
            helper(open, close - 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
