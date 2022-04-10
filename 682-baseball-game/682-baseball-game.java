class Solution {
    public int calPoints(String[] ops) {
        List<Integer> nums = new LinkedList<>();
        for (String op : ops)
        {
            int l = nums.size();
            if (op.equals("+"))
            {
                nums.add(nums.get(l - 1) + nums.get(l - 2));
            }
            else if (op.equals("D"))
            {
                nums.add(nums.get(l - 1) * 2);
            }
            else if (op.equals("C"))
            {
                nums.remove(nums.get(l - 1));
            }
            else
            {
                nums.add(Integer.parseInt(op));
            }
        }
        
        int res = 0;
        for (int num : nums)
            res += num;
            
        return res;
    }
}