class Twitter {
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followersMap;
    int time;

    public Twitter() {
        tweetMap = new HashMap<>();
        followersMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        if(!followersMap.containsKey(userId)) {
           followersMap.put(userId, new HashSet<>());
        }
        tweetMap.get(userId).add(new int[]{tweetId, time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashSet<Integer> followingList = followersMap.get(userId);
        for(int curr : followingList) {
            if(tweetMap.containsKey(curr)) {
                List<int[]> tweets = tweetMap.get(curr);
                for(int[] tweet : tweets) {
                    minQ.offer(tweet);
                    if(minQ.size() > 10) {
                        minQ.poll();
                    }
                }
            }
        }
        if(tweetMap.containsKey(userId)) {
            List<int[]> tweets = tweetMap.get(userId);
            for(int[] tweet : tweets) {
                minQ.offer(tweet);
                if(minQ.size() > 10) {
                    minQ.poll();
                }
            }
        }
        System.out.println(minQ);
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(!minQ.isEmpty()) {
            stack.push(minQ.poll()[0]);
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!followersMap.containsKey(followerId)) {
            followersMap.put(followerId, new HashSet<>());
        }
        followersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.get(followerId).contains(followeeId)) {
            followersMap.get(followerId).remove(followeeId);
        }
    }
}
