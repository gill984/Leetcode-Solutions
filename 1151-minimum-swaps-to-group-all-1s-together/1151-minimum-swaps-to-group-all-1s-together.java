class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int cnt_one = 0, max_one = 0;
        // maintain a deque with the size = ones
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < data.length; i++) {

            // we would always add the new element into the deque
            deque.addLast(data[i]);
            cnt_one += data[i];

            // when there are more than ones elements in the deque,
            // remove the leftmost one
            if (deque.size() > ones) {
                cnt_one -= deque.removeFirst();;
            }
            max_one = Math.max(max_one, cnt_one);
        }
        return ones - max_one;

    }
}