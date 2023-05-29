class ParkingSystem {
    int [] count = new int [4];
    
    public ParkingSystem(int big, int medium, int small) {
        count[1] = big;
        count[2] = medium;
        count[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (count[carType] == 0)
            return false;
        count[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */