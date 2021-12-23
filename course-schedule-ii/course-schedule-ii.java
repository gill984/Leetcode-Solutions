class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] classesLeft = new int [numCourses];
        List<List<Integer>> prereqFor = new ArrayList<List<Integer>>();
        int [] result = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++)
            prereqFor.add(new ArrayList<Integer>());
        
        for(int [] pre : prerequisites)
        {
            classesLeft[pre[0]] += 1;
            prereqFor.get(pre[1]).add(pre[0]);
        }
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        
        // Add all classes with no prereqs
        for(int i = 0; i < classesLeft.length; i++)
            if(classesLeft[i] == 0)
                queue.push(i);
        
        int idx = 0;
        while(!queue.isEmpty())
        {
            int c = queue.pop();
            result[idx++] = c;
            for(int i : prereqFor.get(c))
            {
                classesLeft[i] -= 1;
                
                // Check if all prereqs are done now
                if(classesLeft[i] == 0)
                    queue.push(i);
            }
        }
        
        if(idx == numCourses)
            return result;
        else
            return new int [] {};
    }
}