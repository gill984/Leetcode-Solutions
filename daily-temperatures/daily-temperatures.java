class Solution
{
    public int[] dailyTemperatures(int[] temperatures)
    {
        // Monotonic stack problem I think
        // Stack keep tracks of larger temperatures you have found
        // For each element from end to start
        // Pop stack until top of stack is greater than this temperature
        // add this temperature to the stack
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int [] res = new int [n];
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            
            if (!stack.isEmpty())
                res[i] = stack.peek() - i;
            else
                res[i] = 0;

            stack.push(i);
        }
        
        return res;
    }
}