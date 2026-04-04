class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    Node() {
        this(-1, -1, null);
    }
}
class MyHashMap {
    Node[] map;

    public MyHashMap() {
        map = new Node[1000];
        for(int i = 0;i < 1000;i++) {
            map[i] = new Node();
        }
    }
    
    public void put(int key, int value) {
        Node node = map[key % 1000];
        while(node.next != null) {
            if(node.next.key == key) {
                node.next.value = value;
                return;
            }
            node = node.next;
        }
        node.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        Node node = map[key % 1000].next;
        while(node != null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node node = map[key % 1000];
        while(node.next != null) {
            if(node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */