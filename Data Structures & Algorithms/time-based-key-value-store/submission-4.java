class TimeMap {
    HashMap<String, List<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = hm.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        hm.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) {
            return "";
        }
        String res = "";
        List<Pair> list = hm.get(key);
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(list.get(mid).getTime() <= timestamp) {
                res = list.get(mid).getValue();
            }
            if(list.get(mid).getTime() <= timestamp) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }

    class Pair {
        String value;
        int time;
        Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }

        public int getTime() {
            return this.time;
        }

        public String getValue() {
            return this.value;
        }
    }
}
