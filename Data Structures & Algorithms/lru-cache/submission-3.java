class LRUCache {
    class Node {
        Node prev;
        Node next;
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    int size;
    int capacity;
    Node head;
    HashMap<Integer, Integer> hm = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        this.head = new Node(-1);
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) {
            return -1;
        }
        removeNode(key);
        insertNode(key);
        return hm.get(key);
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            removeNode(key);
        }
        insertNode(key);
        hm.put(key, value);

        if(size > capacity) {
            int count = 0;
            Node curr = head;
            while(count < capacity) {
                count++;
                curr = curr.next;
            }
            hm.remove(curr.next.val);
            curr.next = null;
            size--;
        }
    }

    public void removeNode(int key) {
        Node curr = head;
        while(curr != null && curr.val != key) {
            curr = curr.next;
        }
        Node prev = curr.prev;
        Node next = curr.next;
        prev.next = next;
        if(next != null) {
            next.prev = prev;
        }
        size--;
    }

    public void insertNode(int key) {
        Node curr = head;
        Node newNode = new Node(key);
        newNode.next = curr.next;
        newNode.prev = curr;
        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }
        curr.next = newNode;
        size++;
    }

    
}
