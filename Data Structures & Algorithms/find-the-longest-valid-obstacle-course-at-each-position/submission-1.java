class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, size=0; 
        int[] tails = new int[n], answer = new int[n]; 
        for(int i = 0;i < n;i++) { 
            int lo = 0,hi = size; 
            while(lo < hi) { 
                int mid = (lo + hi) / 2; 
                if(tails[mid] <= obstacles[i]) lo = mid+1; 
                else hi = mid; 
            } 
            tails[lo] = obstacles[i];
            if(lo == size) size++; 
            answer[i] = lo + 1; 
        } 
        return answer;
    }
}
