class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int [] res = new int[k];
        Map<Integer, Set<Integer>> idToMinutes = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < logs.length; i++)
        {
            int id = logs[i][0];
            int time = logs[i][1];
            idToMinutes.putIfAbsent(id, new HashSet<Integer>());
            idToMinutes.get(id).add(time);
        }
        
        for (int id : idToMinutes.keySet())
        {
            res[idToMinutes.get(id).size() - 1] += 1;
        }
        
        return res;
    }
}