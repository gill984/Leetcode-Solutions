class SmallestInfiniteSet {
    Set<Integer> removed;
    PriorityQueue<Integer> available;
    int curr;
    
    public SmallestInfiniteSet() {
        available = new PriorityQueue<>();
        removed = new HashSet<>();
        curr = 1;
    }
    
    public int popSmallest() {
        if (available.isEmpty()) {
            removed.add(curr);
            return curr++;
        }
        
        int res = available.poll();
        removed.add(res);
        return res;
    }
    
    public void addBack(int num) {
        if (!removed.contains(num))
            return;
        
        removed.remove(num);
        available.add(num);
    }
}