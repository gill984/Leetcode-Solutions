class SnapshotArray {
    List<TreeMap<Integer, Integer>> snapshots;
    int id;
    
    public SnapshotArray(int length) {
        snapshots = new ArrayList<>(length);
        id = 0;
        
        for (int i = 0; i < length; i++)
            snapshots.add(new TreeMap<>());
    }
    
    public void set(int index, int val) {
        snapshots.get(index).put(id, val);
    }
    
    public int snap() {
        return id++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = snapshots.get(index);
        Integer key = map.floorKey(snap_id);
        return key == null ? 0 : map.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */