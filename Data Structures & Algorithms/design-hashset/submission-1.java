class Node {
    int value;
    Node next;
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
class MyHashSet {
    Node[] set;

    public MyHashSet() {
        set = new Node[1000];
        for(int i = 0;i < 1000;i++) {
            set[i] = new Node(-1, null);
        }
    }
    
    public void add(int key) {
        Node node = set[key % 1000];
        while(node.next != null) {
            if(node.next.value == key) return;
            node = node.next;
        }
        node.next = new Node(key, null);
    }
    
    public void remove(int key) {
        Node node = set[key % 1000];
        while(node.next != null) {
            if(node.next.value == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
    
    public boolean contains(int key) {
        Node node = set[key % 1000].next;
        while(node != null) {
            if(node.value == key) return true;
            node = node.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */