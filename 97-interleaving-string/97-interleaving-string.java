class Solution
{
    boolean UNVISITED = false;
    boolean VISITED = true;
    boolean [][] memo;
    String s1;
    String s2;
    String s3;
    
    public boolean isInterleave(String s1, String s2, String s3)
    {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        // Memo[x][y] contains true if we successfully used
        // x characters in s1 and y characters in s2 to match
        // x + y characters in s3
        // Note that it does not matter what order the characters
        // were chosen, just which have been chosen so far
        memo = new boolean[s1.length() + 1][s2.length() + 1];
        
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        recurse(0, 0, 0);
        
        return memo[s1.length()][s2.length()];
    }
    
    public void recurse(int s1dx, int s2dx, int s3dx)
    {
        // This prevents going down paths we already tried
        if(memo[s1dx][s2dx] == VISITED)
            return;

        memo[s1dx][s2dx] = VISITED;
        
        // If s3dx is s3.length() at this point, then we have reached the end and solved
        // the original problem
        if(s3dx == s3.length())
            return;
                
        // Try using characters from s1 and also s2 if they match the s3 character.
        // Some paths are only possible when using characters in a certain order
        // however, as stated above, any state which has used the same number
        // of characters in s1 and s2 is identical, it doesn't matter how you reached
        // that state.
        char s3c = s3.charAt(s3dx);
        if(s1dx < s1.length() && s1.charAt(s1dx) == s3c)
            recurse(s1dx + 1, s2dx, s3dx + 1);
        
        if(s2dx < s2.length() && s2.charAt(s2dx) == s3c)
            recurse(s1dx, s2dx + 1, s3dx + 1);
    }
}