class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String curr : tokens) {
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                switch(curr) {
                    case "+" :
                        res = a + b;
                        break;
                    case "-" :
                        res = b - a;
                        break;
                    case "*" :
                        res = a * b;
                        break;
                    case "/" :
                        res = b / a;
                        break;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.peek();
    }
}
