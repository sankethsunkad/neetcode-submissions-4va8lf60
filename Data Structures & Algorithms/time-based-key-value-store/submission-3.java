class TimeMap {
    HashMap<String, Stack<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new Stack<>());
        }
        Pair pair = new Pair(value, timestamp);
        Stack<Pair> stack = hm.get(key);
        stack.push(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) {
            return "";
        }
        Stack<Pair> stack = hm.get(key);
        Stack<Pair> secondary = new Stack<>();
        while(!stack.isEmpty() && stack.peek().getTime() > timestamp) {
            secondary.push(stack.pop());
        }

        String res = "";
        if(!stack.isEmpty()) {
            res = stack.peek().getValue();
        }
        while(!secondary.isEmpty()) {
            stack.push(secondary.pop());
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
