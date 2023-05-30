class MyHashSet {
    boolean [] set;
    int CAPACITY = 1000001;

    public MyHashSet() {
        set = new boolean[CAPACITY];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}