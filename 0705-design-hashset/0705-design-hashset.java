class MyHashSet {
    Integer [] KeySet;
    int CAPACITY = 10000;
    int SKIP = Integer.MAX_VALUE;

    public MyHashSet() {
        KeySet = new Integer[CAPACITY];
    }
    
    public void add(int key) {
        if (contains(key))
            return;
        
        int h = hash(key);
        while (KeySet[h] != null) {
            h = (h + 1) % CAPACITY;
        }
        KeySet[h] = key;
    }
    
    public void remove(int key) {
        int h = hash(key);
        while (KeySet[h] != null) {
            if (KeySet[h] != key) {
                h = (h + 1) % CAPACITY;
                continue;
            }
            
            KeySet[h] = SKIP;
            return;
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        
        while (KeySet[h] != null) {
            if (KeySet[h] == key)
                return true;
            h = (h + 1) % CAPACITY;
        }
        
        return false;
    }
    
    private int hash(int key) {
        return ((key + 7) * 59) % CAPACITY;
    }
}