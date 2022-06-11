class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        for (; i < word.length() && j < abbr.length(); i++, j++) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0')
                    return false;
                
                int num = abbr.charAt(j) - '0';
                while (j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))) {
                    num = (num * 10) + (abbr.charAt(++j) - '0');
                }
                i += num - 1;
            } else if (word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}