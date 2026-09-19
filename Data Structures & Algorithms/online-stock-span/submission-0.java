class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int res = 0;
        int index = list.size() - 1;
        while(index >= 0 && list.get(index) <= price) {
            index--;
            res++;
        }
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */