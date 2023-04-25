class SmallestInfiniteSet {
    Set<Integer> removed;
    TreeSet<Integer> available;
    
    public SmallestInfiniteSet() {
        available = new TreeSet<>();
        removed = new HashSet<>();
        available.add(1);
    }
    
    public int popSmallest() {
        int res = available.first();
        available.remove(res);
        removed.add(res);
        int next = res + 1;
        while (removed.contains(next)) {
            next++;
        }
        available.add(next);
        return res;
    }
    
    public void addBack(int num) {
        if (!removed.contains(num))
            return;
        
        removed.remove(num);
        available.add(num);
    }
}