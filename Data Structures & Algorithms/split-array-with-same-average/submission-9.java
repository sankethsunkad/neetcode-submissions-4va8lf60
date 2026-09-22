
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        boolean possible = false;
        for (int len = 1; len <= n / 2; len++) {
            if ((long) total * len % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible) return false;

        // Equal average becomes finding a nonempty,
        // non-full subset whose transformed sum is zero.
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = (long) nums[i] * n - total;
        }

        int leftSize = n / 2;
        int rightSize = n - leftSize;

        Set<Long> leftSums = new HashSet<>();

        // Store nonempty proper subsets of the left half.
        int leftFull = (1 << leftSize) - 1;
        for (int mask = 1; mask <= leftFull; mask++) {
            long sum = 0;
            for (int i = 0; i < leftSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += values[i];
                }
            }

            if (sum == 0) return true;

            if (mask != leftFull) {
                leftSums.add(sum);
            }
        }

        long leftTotal = 0;
        for (int i = 0; i < leftSize; i++) {
            leftTotal += values[i];
        }

        int rightFull = (1 << rightSize) - 1;
        for (int mask = 1; mask <= rightFull; mask++) {
            long sum = 0;
            for (int i = 0; i < rightSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += values[leftSize + i];
                }
            }

            if (sum == 0) return true;
            if (leftSums.contains(-sum)) return true;

            // Entire left half + a proper right subset is valid.
            if (mask != rightFull && leftTotal + sum == 0) {
                return true;
            }
        }

        return false;
    }
}