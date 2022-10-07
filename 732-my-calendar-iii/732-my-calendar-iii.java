class MyCalendarThree {
    TreeMap<Integer, Integer> times;
    
    public MyCalendarThree() {
        times = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        times.put(start, times.getOrDefault(start, 0) + 1);
        times.put(end, times.getOrDefault(end, 0) - 1);
        int res = 0;
        int count = 0;
        for (int t : times.values()) {
            count += t;
            res = Math.max(count, res);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */