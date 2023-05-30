class MyHashSet {
    Integer [] KeySet;
    int CAPACITY = 100000;

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
            
            KeySet[h] = null;
            shift(h);
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
        return ((key + 7) * 13) % CAPACITY;
    }
    
    private void shift(int idx) {
        int prev = idx;
        idx = (idx + 1) % CAPACITY;
        while (KeySet[idx] != null && idx != hash(KeySet[idx])) {
            KeySet[prev] = KeySet[idx];
            prev = idx;
            idx = (idx + 1) % CAPACITY;
        }
    }
}