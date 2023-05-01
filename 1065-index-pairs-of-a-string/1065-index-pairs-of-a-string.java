class Solution {
    public int[][] indexPairs(String text, String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<int[]> resList = new ArrayList<>();
        for (int start = 0; start < text.length(); start++) {
            for (String word : words) {
                boolean match = true;
                
                if (word.length() + start > text.length()) {
                    break;
                }
                
                for (int j = 0; j + start < text.length() && j < word.length(); j++) {
                    if (word.charAt(j) != text.charAt(j + start)) {
                        match = false;
                        break;
                    }
                }
                
                if (match)
                    resList.add(new int [] {start, start + word.length() - 1});
            }
        }
        
        int [][] res = new int [resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = resList.get(i)[j];
            }
        }
        return res;
    }
}