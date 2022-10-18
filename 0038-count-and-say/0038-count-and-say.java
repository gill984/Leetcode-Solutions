class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            char prev = '0';
            int count = 0;
            StringBuilder curr = new StringBuilder();
            
            for (char c : res.toCharArray()) {
                if (c == prev) {
                    count++;
                } else {
                    if (count > 0) {
                        curr.append(count);
                        curr.append(prev);
                    }
                    count = 1;
                    prev = c;
                }
            }
            
            if (count > 0) {
                curr.append(count);
                curr.append(prev);
            }
            
            res = curr.toString();
        }
        
        return res;
    }
    
    
}