class Solution {
    public int diagonalSum(int[][] mat) {

        int n = mat.length;

        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                //String str = i + "," + j;
                if(i == j || (i + j) == n - 1) {
                    res += mat[i][j];
                    //hashSet.add(str);
                }
            }
        }
        return res;
    }
}