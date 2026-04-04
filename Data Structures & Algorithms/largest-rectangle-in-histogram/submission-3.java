class Solution {
    class Pair {
        int index;
        int height;
        Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0;i < n;i++) {
            if(stack.isEmpty()) {
                stack.push(new Pair(i, heights[i]));
            }
            else {
                if(stack.peek().height <= heights[i]) {
                    stack.push(new Pair(i, heights[i]));
                }
                else {
                    int ind = i;
                    while(!stack.isEmpty() && stack.peek().height > heights[i]) {
                        Pair pair = stack.pop();
                        ind = pair.index;
                        maxArea = Math.max(maxArea, (i - ind) * pair.height);
                    }
                    if(stack.isEmpty()) {
                        stack.push(new Pair(ind, heights[i]));
                    }
                    else {
                        stack.push(new Pair(ind, heights[i]));
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            maxArea = Math.max(maxArea, (n - pair.index) * pair.height);
        }
        return maxArea;
    }
}
