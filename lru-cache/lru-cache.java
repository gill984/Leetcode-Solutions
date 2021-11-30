class LRUCache {
    Map<Integer, Node> map;
    private int capacity;
    private int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key))
        {
            Node n = map.get(key);
            if (head.next != n)
            {
                remove(n);
                add(n);
            }
            
            return n.val;
        }
        else
        {
            return -1;
        }
    }
    
    private void remove(Node n)
    {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void add(Node n)
    {
        if (head.next == n)
            return;
        
        Node headNext = head.next;
        head.next = n;
        n.next = headNext;
        n.next.prev = n;
        n.prev = head;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            Node n = map.get(key);
            n.val = value;
            remove(n);
            add(n);
        }
        else
        {
            if (size == capacity)
            {
                // Remove oldest entry
                Node toRemove = tail.prev;
                remove(toRemove);
                map.remove(toRemove.key, toRemove);
            }
            else
            {
                size++;
            }
            Node n = new Node(key, value);
            add(n);
            map.put(key, n);
        }
    }
}

class Node
{
    Node prev;
    Node next;
    int val;
    int key;
    
    public Node (int k, int v)
    {
        this.key = k;
        this.val = v;
    }
}