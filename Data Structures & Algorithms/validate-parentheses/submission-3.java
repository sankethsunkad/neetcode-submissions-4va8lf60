class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if(ch == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            else if(ch == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
