class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DLList> freqMap;
    int capacity, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DLList list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            keyMap.remove(removed.key);
        }

        Node node = new Node(key, value);
        minFreq = 1;

        DLList list = freqMap.getOrDefault(1, new DLList());
        list.add(node);
        freqMap.put(1, list);

        keyMap.put(key, node);
    }

    private void update(Node node) {
        int freq = node.freq;
        DLList list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLList newList = freqMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}