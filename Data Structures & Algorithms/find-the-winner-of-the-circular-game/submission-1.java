class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int winnerPosition = (findTheWinner(n - 1, k) + k) % n;
        return winnerPosition == 0 ? n : winnerPosition;
    }
}
