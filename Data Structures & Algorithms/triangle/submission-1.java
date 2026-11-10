class Solution {
    private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int index) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][index] != null) {
            return memo[row][index];
        }
        
        int left = dfs(triangle, row + 1, index);
        int right = dfs(triangle, row + 1, index + 1);
        
        return memo[row][index] = triangle.get(row).get(index) + Math.min(left, right);
    }
}
