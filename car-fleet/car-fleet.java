class Solution {
    public int target;
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        this.target = target;
        
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++)
            cars[i] = new Car(position[i], speed[i]);
        Arrays.sort(cars);
        int res = 0;
        
        Car front = cars[0];
        res++;
        for (int i = 1; i < n; i++)
        {
            Car next = cars[i];
            if (next.arrivalTime <= front.arrivalTime)
                continue;
            else
            {
                front = next;
                res++;
            }
        }
        return res;
    }
    
    class Car implements Comparable<Car>
    {
        int position;
        int speed;
        double arrivalTime;
        
        public Car(int position, int speed)
        {
            this.position = position;
            this.speed = speed;
            arrivalTime = (target - position) / ((double) speed);
        }
        
        // Sort descending position
        public int compareTo(Car c)
        {
            return c.position - position;
        }
        
        public String toString()
        {
            return "(Position: " + position + ", speed: " + speed + ", arrivalTime: " + arrivalTime + ")";
        }
    }
}