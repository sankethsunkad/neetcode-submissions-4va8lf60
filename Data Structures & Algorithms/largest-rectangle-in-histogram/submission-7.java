class Solution {
    class Pair {
        int index;
        int val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();

        int res = 0;
        int n = heights.length;
        for(int i = 0;i < n;i++) {
            if(stack.isEmpty()) {
                stack.push(new Pair(i, heights[i]));
            }
            else {
                int ind = i;
                while(!stack.isEmpty() && stack.peek().val >= heights[i]) {
                    Pair pair = stack.pop();
                    ind = pair.index;
                    res = Math.max(res, (i - ind) * pair.val);
                }

                stack.push(new Pair(ind, heights[i]));
            }
        }

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            res = Math.max(res, (n - pair.index) * pair.val);
        }
        return res;
    }
}
