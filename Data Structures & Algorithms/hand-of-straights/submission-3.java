class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        PriorityQueue<Integer> minQ;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for(int i = 0;i < hand.length;i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        minQ = new PriorityQueue<>(map.keySet());
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
