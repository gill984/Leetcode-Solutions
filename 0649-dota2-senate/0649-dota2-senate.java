class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        char [] s = senate.toCharArray();
        
        boolean containsRadiant = true;
        boolean containsDire = true;
        
        int radiantCount = 0;
        int direCount = 0;
        
        while (containsRadiant && containsDire) {
            containsRadiant = false;
            containsDire = false;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'R') {
                    if (direCount > 0) {
                        s[i] = '0';
                        direCount--;
                    } else {
                        radiantCount++;
                        containsRadiant = true;
                    }
                } else if (s[i] == 'D') {
                    if (radiantCount > 0) {
                        s[i] = '0';
                        radiantCount--;
                    } else {
                        direCount++;
                        containsDire = true;
                    }
                }
            }
        }
        
        return (containsRadiant ? "Radiant" : "Dire");
    }
}