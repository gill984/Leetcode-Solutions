class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean [] visited = new boolean[n];
        visited[start] = true;
        return dfs (start, visited, arr);
    }
    
    public boolean dfs(int idx, boolean [] visited, int [] arr)
    {
        if (arr[idx] == 0)
            return true;
        
        boolean success = false;
        if (idx + arr[idx] < arr.length && !visited[idx + arr[idx]])
        {
            visited[idx + arr[idx]] = true;
            success = dfs(idx + arr[idx], visited, arr);
        }
        
        if (!success && idx - arr[idx] >= 0 && !visited[idx - arr[idx]])
        {
            visited[idx - arr[idx]] = true;
            success = dfs(idx - arr[idx], visited, arr);
        }
        
        return success;
    }
}