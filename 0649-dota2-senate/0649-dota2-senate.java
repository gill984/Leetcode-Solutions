class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Character> queue = new ArrayDeque<>();
        int [] count = new int [128];
        int [] remove = new int [128];
        
        for (char c : senate.toCharArray()) {
            count[c]++;
            queue.addLast(c);
        }
        
        while (count['R'] > 0 && count['D'] > 0) {
            char c = queue.removeFirst();
            if (remove[c] > 0) {
                remove[c]--;
                count[c]--;
            } else {
                remove[c == 'R' ? 'D' : 'R']++;
                queue.addLast(c);
            }
        }
        
        
        return (count['R'] > 0 ? "Radiant" : "Dire");
    }
}