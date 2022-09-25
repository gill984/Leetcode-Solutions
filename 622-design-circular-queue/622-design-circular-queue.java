class MyCircularQueue {
    int [] arr;
    int capacity;
    int size;
    int front;  // Inclusive idx
    int back;   // Exclusive idx

    public MyCircularQueue(int k) {
        capacity = k;
        arr = new int [capacity];
        size = 0;
        front = 0;
        back = 0;
    }
    
    public boolean enQueue(int value) {
        if (size == capacity)
            return false;
        arr[back] = value;
        back = (back + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0)
            return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        return size > 0 ? arr[front] : -1;
    }
    
    public int Rear() {
        return size > 0 ? arr[back > 0 ? back - 1 : capacity - 1] : -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}