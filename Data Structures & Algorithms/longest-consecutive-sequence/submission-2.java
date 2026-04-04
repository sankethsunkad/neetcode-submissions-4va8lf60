class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> list = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());
        Collections.sort(list);
        int count = 1;
        int max = 1;
        HashSet<Integer> visited = new HashSet<>();
        int prevVisited = list.get(0);
        visited.add(list.get(0));
        for(int i = 1;i < list.size();i++) {
            if(!visited.contains(list.get(i))) {
                if(list.get(i) - 1 == prevVisited){
                    count++;
                }
                else {
                    count = 1;
                }
                max = Math.max(count, max);
                visited.add(list.get(i));
                prevVisited = list.get(i);
            }
        }
        return max;
    }
}
