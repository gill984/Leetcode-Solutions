class RandomizedSet {
    Map<Integer, Integer> indexOf;
    List<Integer> set;
    Random gen;

    public RandomizedSet() {
        set = new ArrayList<>();
        indexOf = new HashMap<>();
        gen = new Random();
    }
    
    public boolean insert(int val) {
        if (indexOf.containsKey(val))
            return false;
        set.add(val);
        indexOf.put(val, set.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexOf.containsKey(val))
            return false;
        
        int idx = indexOf.get(val);
        set.set(idx, set.get(set.size() - 1));
        set.remove(set.size() - 1);
        indexOf.remove(val, idx);
        if (set.size() > idx) {
            indexOf.remove(set.get(idx), set.size());
            indexOf.put(set.get(idx), idx);
        }
        return true;
    }
    
    public int getRandom() {
        return set.get(gen.nextInt(set.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */