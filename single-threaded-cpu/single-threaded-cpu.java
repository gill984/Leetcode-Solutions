class Solution {
    public int[] getOrder(int[][] inputTasks) {
        int n = inputTasks.length;
        int [][] tasks = new int[n][3];
        int [] res = new int[n];
        int resIdx = 0;
        
        for (int i = 0; i < n; i++)
        {
            tasks[i][0] = inputTasks[i][0];
            tasks[i][1] = inputTasks[i][1];
            tasks[i][2] = i;
        }
        
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minProcessTime = new PriorityQueue<>(
        new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (Integer.compare(a[1], b[1]) == 0)
                    return Integer.compare(a[2], b[2]);
                else
                    return Integer.compare(a[1], b[1]);
            }
        }
        );
        
        int time = tasks[0][0];
        for (int i = 0; i < n;)
        {
            if (time >= tasks[i][0])
            {
                minProcessTime.offer(tasks[i]);
                i++;
            }
            else if (!minProcessTime.isEmpty())
            {
                int [] t = minProcessTime.poll();
                time += t[1];
                res[resIdx++] = t[2];
            }
            else
            {
                time = tasks[i][0];
                minProcessTime.offer(tasks[i]);
                i++;
            }
        }
        
        while(!minProcessTime.isEmpty())
            res[resIdx++] = minProcessTime.poll()[2];
        
        return res;
    }
}