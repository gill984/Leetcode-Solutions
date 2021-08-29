class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        List<Integer> left = new ArrayList<Integer>();
        for (int i = 0; i < asteroids.length; i++)
        {
            if (asteroids[i] > 0)
            {
                stack.push(asteroids[i]);
            }
            else if (asteroids[i] < 0)
            {
                while (!stack.isEmpty() && stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
                else if (stack.isEmpty())
                    left.add(asteroids[i]);
            }
        }
        
        int [] result = new int [left.size() + stack.size()];
        for (int i = 0; i < left.size(); i++)
            result[i] = left.get(i);
        for (int i = result.length - 1; !stack.isEmpty(); i--)
            result[i] = stack.pop();
        
        return result;
    }
}