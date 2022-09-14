class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new int [10], 0);
    }
    
    public boolean isPermutePalindrome (int [] counts, int length) {
        if (length % 2 == 0) {
            // All counts must be even
            for (int count : counts)
                if (count % 2 == 1)
                    return false;
            return true;
        } else {
            // All even count except 1 must be odd
            int oddCount = 0;
            for (int count : counts) {
                if (count % 2 == 1) {
                    oddCount++;
                }
            }
            return oddCount == 1;
        }
    }
    
    public int dfs(TreeNode curr, int [] counts, int length) {
        if (curr == null)
            return 0;
        
        counts[curr.val] += 1;
        length += 1;
        if (curr.left == null && curr.right == null && isPermutePalindrome(counts, length)) {
            counts[curr.val] -= 1;
            return 1;
        }
        int left = dfs(curr.left, counts, length);
        int right = dfs(curr.right, counts, length);
        counts[curr.val] -= 1;
        return left + right;
    }
}