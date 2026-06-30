class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for(int i = 0;i < hand.length;i++) {
            int count = 1;
            while((i + 1) < hand.length && hand[i] == hand[i + 1]) {
                i++;
                count++;
            }
            minQ.offer(hand[i]);
            map.put(hand[i], count);
        }

        while(!minQ.isEmpty()) {
            int curr = minQ.peek();
            for(int i = curr; i < curr + groupSize;i++) {
                if(!map.containsKey(i)) {
                    return false;
                }
                
                map.put(i, map.get(i) - 1);

                if(map.get(i) == 0) {
                    if(minQ.peek() != i) {
                        return false;
                    }
                    minQ.poll();
                }
            }
        }
        return true;
    }
}
