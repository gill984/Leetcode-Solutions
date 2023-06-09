class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int idx = binarySearchRight(letters, target, n);
        return letters[idx];
    }
    
    public int binarySearchRight(char[] letters, char target, int n) {
        int lo = 0;
        int hi = n - 1;
        
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (letters[mid] <= target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        
        return lo == n ? 0 : lo;
    }
}