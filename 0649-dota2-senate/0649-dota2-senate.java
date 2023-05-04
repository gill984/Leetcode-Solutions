class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Character> queue = new ArrayDeque<>();
        int rCount = 0;
        int dCount = 0;
        
        for (char c : senate.toCharArray()) {
            if (c == 'R')
                rCount++;
            else
                dCount++;
            queue.addLast(c);
        }
        
        int removeR = 0;
        int removeD = 0;
        
        while (rCount > 0 && dCount > 0) {
            char c = queue.removeFirst();
            
            if (c == 'R') {
                if (removeR > 0) {
                    removeR--;
                    rCount--;
                } else {
                    removeD++;
                    queue.addLast(c);
                }
            } else {
                if (removeD > 0) {
                    removeD--;
                    dCount--;
                } else {
                    removeR++;
                    queue.addLast(c);
                }
            }
        }
        
        
        return (rCount > 0 ? "Radiant" : "Dire");
    }
}