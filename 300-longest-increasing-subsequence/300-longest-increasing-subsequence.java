class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for (int num : nums) {
            if (bst.isEmpty() || bst.last() < num) {
                bst.add(num);
            } else {
                bst.remove(bst.ceiling(num));
                bst.add(num);
            }
        }
        
        return bst.size();
    }
}