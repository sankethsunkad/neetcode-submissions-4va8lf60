class FreqStack {
    HashMap<Integer, Integer> hm;
    HashMap<Integer, List<Integer>> countMap;
    int max;
    public FreqStack() {
        hm = new HashMap<>();
        countMap = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int freq = hm.getOrDefault(val, 0) + 1;
        max = Math.max(freq, max);
        countMap.putIfAbsent(freq, new ArrayList<>());
        countMap.get(freq).add(val);
        hm.put(val , freq);
    }
    
    public int pop() {
        List<Integer> maxList = countMap.get(max);
        int val = maxList.remove(maxList.size() - 1);
        if(maxList.size() == 0) max--;
        hm.put(val, hm.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */