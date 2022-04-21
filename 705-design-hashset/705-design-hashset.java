class MyHashSet {
    HashSetEntry [] table;
    final int size = 9973;
    
    public MyHashSet()
    {
        table = new HashSetEntry [size];
    }
    
    public void add(int key) {
        int h = hash(key);
        
        if (table[h] == null)
            table[h] = new HashSetEntry(key);
        else
            table[h].insert(key);
    }
    
    private int hash(int key) {
        return Math.floorMod(key * 1009 + 13, size);
    }
    
    public void remove(int key) {
        int h = hash(key);
        if (table[h] == null)
        {
            return;
        }
        else
        {
            table[h].remove(key);
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        if (table[h] == null)
            return false;
        else
            return table[h].contains(key);
    }
    
    class HashSetEntry
    {
        List<Integer> keys;
        public HashSetEntry(int key)
        {
            keys = new ArrayList<Integer>();
            keys.add(key);
        }
        
        public void insert (int key)
        {
            int pos = Collections.binarySearch(keys, key);
            if (pos < 0)
                keys.add(-(pos + 1), key);
        }
        
        public void remove (int key)
        {
            int pos = Collections.binarySearch(keys, key);
            if (pos >= 0)
                keys.remove(pos);
        }
        
        public boolean contains(int key)
        {
            return Collections.binarySearch(keys, key) >= 0;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */