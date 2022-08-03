class MyCalendar {
    TreeMap<Integer, Integer> schedule;
        
    public MyCalendar() {
        schedule = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = schedule.floorEntry(start);
        Map.Entry<Integer, Integer> ceil = schedule.ceilingEntry(start);
        if (ceil != null && end > ceil.getKey() || floor != null && floor.getValue() > start)
            return false;
        schedule.put(start, end);
        return true;
    }
}