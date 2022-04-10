class Solution {
    public int calPoints(String[] ops) {
        List<Integer> nums = new ArrayList<>();
        for (String op : ops)
        {
            if (op.equals("+"))
            {
                nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
            }
            else if (op.equals("D"))
            {
                nums.add(nums.get(nums.size() - 1) * 2);
            }
            else if (op.equals("C"))
            {
                nums.remove(nums.get(nums.size() - 1));
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