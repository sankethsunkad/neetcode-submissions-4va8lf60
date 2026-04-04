class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(hand);
        for(int num : hand) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(int num : hand) {
            if(hm.get(num) > 0) {
                for(int i = num;i < num + groupSize;i++) {
                    if(hm.getOrDefault(i, 0) == 0) return false;
                    else {
                        hm.put(i, hm.get(i) - 1);
                    }
                }
            }
        }
        return true;
    }
}
