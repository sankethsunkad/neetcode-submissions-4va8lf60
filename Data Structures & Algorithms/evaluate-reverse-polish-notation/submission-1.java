class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                switch(token) {
                    case "+" :
                        res = a + b;
                        break;
                    case "-":
                        res = b - a;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        if (a == 0) {
                            throw new UnsupportedOperationException("Cannot divide by zero");
                        }
                        res = b / a;
                        break;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
