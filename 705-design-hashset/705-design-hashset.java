class MyHashSet {
    int [] table;
    final int size = 9973;
    
    public MyHashSet()
    {
        table = new int [size];
        Arrays.fill(table, -1);
    }
    
    public void add(int key) {
        int h = hash(key);
        
        for (int i = h; ; )
        {
            if (table[i] == -1)
            {
                table[i] = key;
                return;
            }
            else if (table[i] == key)
            {
                return;
            }
            
            i = (i + 1) % size;
        }
    }
    
    private int hash(int key) {
        return Math.floorMod(key * 1009 + 13, size);
    }
    
    public void remove(int key) {
        int h = hash(key);
        for (int i = h; ;)
        {
            if (table[i] == -1)
            {
                return;
            }
            else if (table[i] == key)
            {
                table[i] = -table[i];
                return;
            }
            i = (i + 1) % size;
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        for (int i = h; ;)
        {
            if (table[i] == -1)
            {
                return false;
            }
            else if (table[i] == key)
            {
                return true;
            }
            i = (i + 1) % size;
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