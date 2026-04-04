class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(new ArrayList<>(), n, n);
        return res;
    }
    void helper(List<Character> str, int openingBraces, int closingBraces) {
        if(closingBraces == 0) {
            String result = str.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            res.add(result);
            return;
        }
        if(openingBraces > 0) {
            str.add('(');
            helper(str,openingBraces - 1, closingBraces);
            str.remove(str.size() - 1);
        }
        if(closingBraces > openingBraces) {
            str.add(')');
            helper(str,openingBraces, closingBraces - 1);
            str.remove(str.size() - 1);
        }
        return;
    }
}
