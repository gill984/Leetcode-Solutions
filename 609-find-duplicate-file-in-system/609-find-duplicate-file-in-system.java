class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // Map file contents to path strings
        Map<String, List<String>> contentToPaths = new HashMap<>();
        for (String s : paths) {
            int idx = s.indexOf(" ");
            String dir = s.substring(0, idx);
            
            while (idx != -1 && idx < s.length()) {
                int contentStart = s.indexOf('(', idx);
                String fileName = s.substring(idx + 1, contentStart);
                int contentEnd = getContent(s, contentStart);
                String content = s.substring(contentStart + 1, contentEnd);
                contentToPaths.putIfAbsent(content, new ArrayList<>());
                contentToPaths.get(content).add(dir + "/" + fileName);
                idx = contentEnd + 1;
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : contentToPaths.values()) {
            if (value.size() > 1)
                res.add(value);
        }
        return res;
    }
    
    public int getContent(String s, int contentStart) {
        int parenCount = 1;
        int i = contentStart + 1;
        for (; ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                parenCount++;
            } else if (c == ')') {
                parenCount--;
            }
            
            if (parenCount == 0) {
                break;
            }
        }
        return i;
    }
}