class ParkingSystem {
    int [] count;
    
    public ParkingSystem(int big, int medium, int small) {
        count = new int [] {0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (count[carType] == 0)
            return false;
        count[carType]--;
        return true;
    }
}