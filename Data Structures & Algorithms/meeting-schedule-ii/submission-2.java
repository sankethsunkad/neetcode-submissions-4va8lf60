/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        for(Interval intervalist:intervals) {
            startList.add(intervalist.start);
            endList.add(intervalist.end);
        }

        Collections.sort(startList);
        Collections.sort(endList);

        int count = 0, maxcount = 0;
        int i = 0, j =0;
        while(i < endList.size()) {
            if(startList.get(i) < endList.get(j)) {
                count++;
                maxcount = Math.max(count, maxcount);
                i++;
            }
            else {
                j++;
                count--;
            }
        }
        return maxcount;
    }
}
