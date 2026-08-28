/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int index = helper(mountainArr, n - 1);
        if(index != -1 && mountainArr.get(index) == target) return index;
        int res = searchLeft(mountainArr, 0, index, target);
        if(res == -1) {
            return searchRight(mountainArr, index + 1, n - 1, target);
        }
        return res;
    }

    int helper(MountainArray mountainArr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    int searchLeft(MountainArray mountainArr, int low, int high, int target) {
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        int midElement = mountainArr.get(mid);
        if(midElement == target) return mid;
        if(target < midElement) {
            return searchLeft(mountainArr, low, mid - 1, target);
        }
        return searchLeft(mountainArr, mid + 1, high, target);
    }

    int searchRight(MountainArray mountainArr, int low, int high, int target) {
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        int midElement = mountainArr.get(mid);
        if(midElement == target) return mid;
        if(target > midElement) {
            return searchRight(mountainArr, low, mid - 1, target);
        }
        return searchRight(mountainArr, mid + 1, high, target);
    }
}