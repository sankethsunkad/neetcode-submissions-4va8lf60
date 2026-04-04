class Solution {
    public List<String> generateParenthesis(int n) {
        List<Character> list = new ArrayList<>();
       return generateParenthesis(n, n, list);
    }

    public List<String> generateParenthesis(int openBraces, int closingBraces, List<Character> list) {
        List<String> res = new ArrayList<>();
        if(closingBraces == 0) {
            String result = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            res.add(result);
            return res;
        }
        if(openBraces > 0) {
            List<Character> newList = new ArrayList<>(list);
            newList.add('(');
            res.addAll(generateParenthesis(openBraces - 1, closingBraces, newList));
        }
        if(closingBraces > openBraces) {
            List<Character> newList = new ArrayList<>(list);
             newList.add(')');
            res.addAll(generateParenthesis(openBraces, closingBraces - 1, newList));
        }
        return res;
    }  
}
