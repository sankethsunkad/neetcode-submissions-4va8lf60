class BrowserHistory {
    class List {
        String url;
        List prev;
        List next;

        List(String url, List prev, List next) {
            this.url = url;
            this.prev = prev;
            this.next = next;
        }
    }

    List head;
    List base;
    public BrowserHistory(String homepage) {
        base = new List("-1", null, null);
        head = new List(homepage, base, null);
        base.next = head;
    }
    
    public void visit(String url) { 
        List node = new List(url, head, null);
        head.next = node;
        head = head.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && head.prev.url != "-1") {
            head = head.prev;
            steps--;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        while(head.next != null && steps > 0) {
            head = head.next;
            steps--;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */