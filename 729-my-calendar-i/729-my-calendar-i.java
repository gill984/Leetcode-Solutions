class MyCalendar {
    TreeMap<Integer, Integer> schedule;
        
    public MyCalendar() {
        schedule = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = schedule.floorEntry(start);
        Map.Entry<Integer, Integer> ceil = schedule.ceilingEntry(start);
        if (ceil != null && end - 1 >= ceil.getKey()) {
            return false;
        } else if (floor != null && floor.getValue() - 1 >= start) {
            return false;
        }
        schedule.put(start, end);
        return true;
    }
}