class HitCounter {
    Map<Integer, Integer> count;
    public HitCounter() {
        count = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        count.put(timestamp, count.getOrDefault(timestamp, 0) + 1);
    }
    
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = timestamp - 299; i <= timestamp; i++) {
            res += count.getOrDefault(i, 0);
        }
        return res;
    }
}