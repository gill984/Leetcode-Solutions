class ParkingSystem {
    int big;
    int medium;
    int small;
    
    int BIG = 1;
    int MED = 2;
    int SML = 3;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == BIG && big > 0) {
            big--;
            return true;
        } else if (carType == MED && medium > 0) {
            medium--;
            return true;
        } else if (carType == SML && small > 0) {
            small--;
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */