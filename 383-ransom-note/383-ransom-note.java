class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] ransomCount = new int [128];
        int [] magazineCount = new int [128];
        
        for (char c : ransomNote.toCharArray())
            ransomCount[c]++;
        for (char c : magazine.toCharArray())
            magazineCount[c]++;
        
        for (int i = 0; i < ransomCount.length; i++)
            if (ransomCount[i] > magazineCount[i])
                return false;
        
        return true;
    }
}