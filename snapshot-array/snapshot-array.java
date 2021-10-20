class SnapshotArray {
    // Assume no calls to get() before first snap() call
    // Assume no out of bounds index calls to set() or get()
    Map<Integer, List<Pair>> indexToSnapValue;
    int snapId;
    
    public SnapshotArray(int length) {
        indexToSnapValue = new HashMap<>();
        snapId = 0;
    }
    
    public void set(int index, int val) {
        indexToSnapValue.putIfAbsent(index, new ArrayList<Pair>());
        List<Pair> pairs = indexToSnapValue.get(index);
        
        // If we already have updated a value during this snap period, update rather than add
        if (pairs.size() > 0 && pairs.get(pairs.size() - 1).snapId == this.snapId)
            pairs.get(pairs.size() - 1).value = val;
        else
            pairs.add(new Pair(this.snapId, val));
    }
    
    public int snap() {
        snapId += 1;
        return snapId - 1;
    }
    
    public int get(int index, int snap_id) {
        // If there are no entries, it's still 0
        if (!indexToSnapValue.containsKey(index))
            return 0;
        
        List<Pair> pairs = indexToSnapValue.get(index);
        int find = Collections.binarySearch(pairs, new Pair(snap_id, 0));
        if (find < 0)
            find = (-1 * (find + 1)) - 1;
        
        if (find < 0)
            return 0;
        else
            return pairs.get(find).value;
    }
    
    class Pair implements Comparable<Pair>
    {
        int snapId;
        int value;
        
        public Pair (int s, int v)
        {
            this.snapId = s;
            this.value = v;
        }
        
        public int compareTo(Pair p)
        {
            return this.snapId - p.snapId;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */