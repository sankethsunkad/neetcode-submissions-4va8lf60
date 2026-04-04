class Solution {
    public int findJudge(int n, int[][] trust) {
        Stack<Integer> hs = new Stack<>();
        for(int[] num : trust) {
            if(hs.isEmpty()) {
                hs.push(num[1]);
            }
            else {
                if(hs.peek() != num[1]) {
                    return -1;
                }
            }
        }
        return hs.pop();
    }
}