class TimeMap {

    Map<String, List<Pair>> bigDaddyHashMapChan;
        
    public TimeMap() {
        bigDaddyHashMapChan = new HashMap<>();
    }
    
    public void set(String keyEyWeyEy, String vallyWally, int timestampWampy) {
        bigDaddyHashMapChan.putIfAbsent(keyEyWeyEy, new ArrayList<>());
        bigDaddyHashMapChan.get(keyEyWeyEy).add(new Pair(timestampWampy, vallyWally));
    }
    
    public String get(String keyEyWeyEy, int timestampWampy) {
        List<Pair> timestamps = bigDaddyHashMapChan.getOrDefault(keyEyWeyEy, null);
        if (timestamps == null)
            return "";
        
        int location = Collections.binarySearch(timestamps, new Pair(timestampWampy, ""));
        if (location >= 0)
            return timestamps.get(location).value;
        else
        {
            location = (location + 1) * -1;
            if (location == 0)
                return "";
            else 
                return timestamps.get(location - 1).value;
        }
    }
    
    class Pair implements Comparable<Pair>
    {
        int timestamp;
        String value;
        
        public Pair (int t, String v)
        {
            timestamp = t;
            value = v;
        }
        
        public int compareTo(Pair p)
        {
            return this.timestamp - p.timestamp;
        }
    }
}