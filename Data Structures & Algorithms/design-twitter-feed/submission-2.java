class Twitter {
    int time;
    HashMap<Integer, HashSet<Integer>> followingList;
    HashMap<Integer, List<int[]>> tweetMap;
    public Twitter() {
        time = 0;
        followingList = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        followingList.putIfAbsent(userId, new HashSet<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(userId);
        followingList.putIfAbsent(userId, new HashSet<>());
        for(int item : followingList.get(userId)) {
            queue.offer(item);
        }
        while(!queue.isEmpty()) {
            int item = queue.poll();
            tweetMap.putIfAbsent(item, new ArrayList<>());
            for(int[] curr : tweetMap.get(item)) {
                maxHeap.offer(curr);
            }
        }
        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            res.add(curr[1]);
            if(res.size() == 10) break;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followingList.putIfAbsent(followerId, new HashSet<>());
        if(followerId == followeeId) return;
        followingList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followingList.get(followerId).remove(followeeId);
    }
}
