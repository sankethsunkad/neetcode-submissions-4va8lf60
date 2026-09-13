class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int res = -1;

        for(int i = 0;i < arr.length;i++) {
            int count = 1;
            while((i + 1) < arr.length && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }
            if(count == arr[i]) {
                res = Math.max(res, arr[i]);
            }
        }
        return res;
    }
}