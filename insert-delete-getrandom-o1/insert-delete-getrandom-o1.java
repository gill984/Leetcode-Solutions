class RandomizedSet {
    ArrayList<Integer> nums;
    Map<Integer, Integer> valueToIndex;
    Random gen;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        valueToIndex = new HashMap<Integer, Integer>();
        gen = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!valueToIndex.containsKey(val))
        {
            valueToIndex.put(val, nums.size());
            nums.add(val);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valueToIndex.containsKey(val))
        {
            int end = nums.size() - 1;
            int idx = valueToIndex.get(val);
            int endVal = nums.get(end);

            if (idx == end)
            {
                nums.remove(end);
                valueToIndex.remove(val);
            }
            else
            {
                nums.set(idx, endVal);
                valueToIndex.put(endVal, idx);
                nums.remove(end);
                valueToIndex.remove(val);
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = gen.nextInt(nums.size());
        return nums.get(idx);
    }
}