class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : people) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int boats = 0;
        for(int i = 0;i < people.length;i++) {
            if(hm.get(people[i]) > 0) {
                hm.put(people[i], hm.get(people[i]) - 1);
                boats++;
                int remaining = limit - people[i];
                while(remaining > 0 && (!hm.containsKey(remaining) || hm.get(remaining) == 0)){
                    remaining--;
                }
                if(hm.containsKey(remaining) && hm.get(remaining) > 0) {
                    hm.put(remaining, hm.get(remaining) - 1);
                }
            }
        }
        return boats;
    }
}