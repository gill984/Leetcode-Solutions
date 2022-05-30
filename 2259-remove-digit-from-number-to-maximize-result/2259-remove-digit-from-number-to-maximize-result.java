class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int place = 0;
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) != digit)
                continue;
            
            place = i;
            if (i + 1 == n || number.charAt(i + 1) > digit)
                break;
        }
        
        return number.substring(0, place) + (place + 1 < n ? number.substring(place + 1, n) : "");
    }
}