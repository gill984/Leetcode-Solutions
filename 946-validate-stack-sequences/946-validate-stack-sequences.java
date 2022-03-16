class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Greedily we want to always pop if possible
        int push = 0;
        int pop = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        while (pop < popped.length)
        {
            if (!stack.isEmpty() && popped[pop] == stack.peekFirst())
            {
                stack.removeFirst();
                pop++;
            }
            else if (push < pushed.length)
            {
                stack.addFirst(pushed[push++]);
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}