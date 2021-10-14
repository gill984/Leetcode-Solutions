class TimeMap {

    Map<String, TreeMap<Integer, String>> bigDaddyTreeMap;
        
    public TimeMap() {
        bigDaddyTreeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        bigDaddyTreeMap.putIfAbsent(key, new TreeMap<>());
        bigDaddyTreeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (bigDaddyTreeMap.containsKey(key))
        {
            TreeMap<Integer, String> smallDaddyTreeMap = bigDaddyTreeMap.get(key);
            if (smallDaddyTreeMap.floorKey(timestamp) != null)
                return smallDaddyTreeMap.get(smallDaddyTreeMap.floorKey(timestamp));
            else
                return "";
        }
        else
        {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */