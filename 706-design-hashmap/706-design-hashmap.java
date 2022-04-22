class MyHashMap {
    int size;
    HashMapEntry [] table;
    
    public MyHashMap() {
        size = 10009;
        table = new HashMapEntry [size];
    }
    
    public void put(int key, int value) {
        int h = hash(key);
        if (table[h] == null)
        {
            table[h] = new HashMapEntry(key, value);
        }
        else
        {
            table[h].put(key, value);
        }
    }
    
    public int get(int key) {
        int h = hash(key);
        if (table[h] == null)
            return -1;
        else
            return table[h].get(key);
    }
    
    public void remove(int key) {
        int h = hash(key);
        if (table[h] != null)
            table[h].remove(key);
    }
    
    private int hash(int key)
    {
        return (key * 31 + 17) % size;
    }
    
    class HashMapEntry
    {
        List<Pair> pairs;
        
        public HashMapEntry(int key, int value)
        {
            pairs = new ArrayList<Pair>();
            pairs.add(new Pair(key, value));
        }
        
        public void put (int key, int value)
        {
            Pair p = new Pair(key, value);
            int pos = Collections.binarySearch(pairs, p);
            if (pos < 0)
            {
                pairs.add(-(pos + 1), p);
            }
            else
            {
                pairs.set(pos, p);
            }
        }
        
        public int get(int key)
        {
            int pos = Collections.binarySearch(pairs, new Pair(key, 0));
            if (pos < 0)
                return -1;
            else
                return pairs.get(pos).value;
        }
        
        public void remove(int key)
        {
            int pos = Collections.binarySearch(pairs, new Pair(key, 0));
            if (pos >= 0)
                pairs.remove(pos);                
        }
        
        class Pair implements Comparable<Pair>
        {
            int key;
            int value;
            
            public Pair(int k, int v)
            {
                this.key = k;
                this.value = v;
            }
            
            public boolean equals(Object o)
            {
                Pair p = (Pair) o;
                return this.key == p.key;
            }
            
            public int compareTo(Pair p)
            {
                return this.key - p.key;
            }
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