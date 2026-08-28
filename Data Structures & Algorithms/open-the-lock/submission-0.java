class Solution {
    private final int[][] dirs = {
        {1, 0, 0, 0}, {-1, 0, 0, 0},
        {0, 1, 0, 0}, {0, -1, 0, 0},
        {0, 0, 1, 0}, {0, 0, -1, 0},
        {0, 0, 0, 1}, {0, 0, 0, -1}
    };

    public int openLock(String[] deadends, String target) {
        int[][][][] lock = new int[10][10][10][10];

        for (String deadend : deadends) {
            int[] state = convert(deadend);
            lock[state[0]][state[1]][state[2]][state[3]] = -1;
        }

        // Starting position is blocked.
        if (lock[0][0][0][0] == -1) {
            return -1;
        }

        int[] targetArray = convert(target);

        if (check(0, 0, 0, 0, targetArray)) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});

        // Mark visited when adding to the queue.
        lock[0][0][0][0] = 1;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int a = 0; a < size; a++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int ni = (curr[0] + dir[0] + 10) % 10;
                    int nj = (curr[1] + dir[1] + 10) % 10;
                    int nk = (curr[2] + dir[2] + 10) % 10;
                    int nl = (curr[3] + dir[3] + 10) % 10;

                    if (lock[ni][nj][nk][nl] != 0) {
                        continue;
                    }

                    if (check(ni, nj, nk, nl, targetArray)) {
                        return moves + 1;
                    }

                    lock[ni][nj][nk][nl] = 1;
                    queue.offer(new int[]{ni, nj, nk, nl});
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] convert(String state) {
        int[] result = new int[4];

        for (int i = 0; i < 4; i++) {
            result[i] = state.charAt(i) - '0';
        }

        return result;
    }

    private boolean check(int i, int j, int k, int l, int[] target) {
        return i == target[0]
                && j == target[1]
                && k == target[2]
                && l == target[3];
    }
}