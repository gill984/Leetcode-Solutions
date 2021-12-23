class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        
        Map<Character, Character> conversionMappings = new HashMap<>();
        Set<Character> uniqueCharactersInStr2 = new HashSet<>();
        
        // Make sure that no character in str1 is mapped to multiple characters in str2.
        for (int i = 0; i < str1.length(); i++) {
           if (!conversionMappings.containsKey(str1.charAt(i))) {
                conversionMappings.put(str1.charAt(i), str2.charAt(i));
                uniqueCharactersInStr2.add(str2.charAt(i));
            } else if (conversionMappings.get(str1.charAt(i)) != str2.charAt(i)) {
                // this letter maps to 2 different characters, so str1 cannot transform into str2.
                return false;
            }
        }
        
        // No character in str1 maps to 2 or more different characters in str2 and there
        // is at least one temporary character that can be used to break any loops.
        if (uniqueCharactersInStr2.size() < 26) {
            return true;
        }

        // The conversion mapping forms one or more cycles and there are no temporary 
        // characters that we can use to break the loops, so str1 cannot transform into str2.
        return false;
    }
}