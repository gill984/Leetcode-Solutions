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
        Map.Entry<Integer, Integer> entry = map.floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}