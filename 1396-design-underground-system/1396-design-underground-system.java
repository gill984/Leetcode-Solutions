class UndergroundSystem {
    Map<Integer, Timestamp> checkins;
    Map<String, Fraction> times;
    
    
    public UndergroundSystem() {
        checkins = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkins.put(id, new Timestamp(t, stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Timestamp ts = checkins.get(id);
        String key = ts.station + "," + stationName;
        int dt = t - ts.time;
        if (times.containsKey(key))
            times.get(key).add(dt);
        else
            times.put(key, new Fraction(dt));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return times.get(startStation + "," + endStation).getAverage();
    }
    
    class Timestamp
    {
        int time;
        String station;
        
        public Timestamp (int t, String s) {
            time = t;
            station = s;
        }
    }
    
    class Fraction
    {
        int numerator;
        int denominator;
        
        public Fraction(int n) {
            numerator = n;
            denominator = 1;
        }
        
        public void add (int n) {
            numerator += n;
            denominator += 1;
        }
        
        public double getAverage() {
            return (double) numerator / (double) denominator;
        }
    }
}