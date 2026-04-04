class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{ newInterval };
        }
        int target = newInterval[0];
        int n = intervals.length;

        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(intervals[mid][0] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }


        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < start - 1) {
            res.add(intervals[i]);
            i++;
        }

        if(start - 1 >= 0 && intervals[start - 1][1] >= newInterval[0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[start - 1][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[start - 1][1]); 
        }
        else if(start - 1 >= 0) {
            res.add(intervals[start - 1]);
        }
        
        i = start;
        
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        int len = res.size();
        int[][] ans = new int[len][2];
        for (i = 0; i < len; i++) ans[i] = res.get(i);
        return ans;
    }
}
