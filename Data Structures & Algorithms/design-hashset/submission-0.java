class Node {
    int value;
    Node next;
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    Node() {
        this.value = -1;
        this.next = null;
    }
}
class MyHashSet {
    Node head;

    public MyHashSet() {
        head = new Node();
    }
    
    public void add(int key) {
        Node node = head;
        while(node.next != null) {
            if(node.next.value == key) return;
            node = node.next;
        }
        node.next = new Node(key, null);
    }
    
    public void remove(int key) {
        Node node = head;
        while(node.next != null) {
            if(node.next.value == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
    
    public boolean contains(int key) {
        Node node = head.next;
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