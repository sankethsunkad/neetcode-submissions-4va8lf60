class TimeMap {
    // key -> list of [timestamp, value] pairs
    HashMap<String, List<Pair>> store;

    static class Pair {
        int time;
        String value;
        Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        
        List<Pair> list = store.get(key);
        // Binary search for latest timestamp <= given timestamp
        int left = 0, right = list.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1; // try to find a later timestamp
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
