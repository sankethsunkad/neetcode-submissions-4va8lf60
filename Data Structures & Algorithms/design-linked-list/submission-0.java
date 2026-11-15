class MyLinkedList {
    class Node {
        int val = -1;;
        Node(int val) {
            this.val = val;
        }
        Node prev = null;
        Node next = null;
        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    Node head;
    int size = 0;
    public MyLinkedList() {
        head = new Node(-1);
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        int i = 0;
        Node curr = head.next;
        while(i < index) {
            curr = curr.next;
            i++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        if(next != null) {
            next.prev = node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);

        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node curr = head;
        while(i < index) {
            curr = curr.next;
            i++;
        }

        Node node = new Node(val);
        Node next = curr.next;
        curr.next = node;
        node.prev = curr;
        node.next = next;
        if(next != null) {
            next.prev = node;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        int i = 0;
        Node curr = head;
        while(i < index) {
            curr = curr.next;
            i++;
        }
        Node next = curr.next.next;
        curr.next = next;
        if(next != null) {
            next.prev = curr;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */