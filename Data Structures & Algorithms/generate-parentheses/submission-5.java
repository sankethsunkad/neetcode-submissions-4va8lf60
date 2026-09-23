class Solution {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;

        backtrack(0, 0, new StringBuilder());
        return res;    
    }

    void backtrack(int open, int close, StringBuilder sb) {
        if(open + close == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if(open > close) {
            sb.append(')');
            backtrack(open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(open < n) {
            sb.append('(');
            backtrack(open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
