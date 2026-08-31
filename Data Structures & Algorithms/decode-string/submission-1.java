class Solution {
    public String decodeString(String s) {
        return helper(new StringBuilder(), 0, s).toString();
    }

    StringBuilder helper(StringBuilder str, int index, String s) {
        if(index == s.length()) return str;

        char ch = s.charAt(index);
        if(ch >= 'a' && ch <= 'z') {
            str.append(ch);
            return helper(str, index + 1, s);
        }
        if(Character.isDigit(ch)) {
            int i = index;
            int repeat = 0;
            while(Character.isDigit(s.charAt(i))) {
                repeat = repeat * 10 + (s.charAt(i) - '0');
                i++;
            }
            int j = i;
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(j));
            j++;
            while(!stack.isEmpty()) {
                if(s.charAt(j) == '[') {
                    stack.push(s.charAt(j));
                }
                else if(s.charAt(j) == ']') {
                    stack.pop();
                }
                j++;
            }
            for(int a = 0;a < repeat;a++) {
                str.append(helper(new StringBuilder(), 0, s.substring(i + 1, j)));
            }
            return helper(str, j, s);
        }

        return str;
    }
}