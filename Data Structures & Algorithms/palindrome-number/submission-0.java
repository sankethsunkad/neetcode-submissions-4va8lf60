class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        Deque<Integer> stack = new LinkedList<>();
        while(x > 0) {
            int num = x % 10;
            x = x / 10;
            stack.push(num);
        }

        while(stack.size() > 0) {
            int front = stack.pollFirst();
            if(stack.isEmpty()) return true;

            int back = stack.pollLast();
            if(front != back) return false;
        }
        return true;
    }
}