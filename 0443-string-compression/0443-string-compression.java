class Solution {
    public int compress(char[] chars) {
        int udx = 0;        // uncompressed index
        int cdx = 0;        // compressed index
        int count = 0;
        
        while (udx <= chars.length) {
            char c = udx < chars.length ? chars[udx] : '0';
            
            if (udx == 0 || chars[udx - 1] == c) {
                count++;
            } else {
                char prev = chars[udx - 1];
                if (count == 1) {
                    chars[cdx] = prev;
                    cdx++;
                } else if (count > 1) {
                    chars[cdx] = prev;
                    List<Character> countArr = toArr(count);
                    for (int i = 0; i < countArr.size(); i++) {
                        chars[cdx + 1 + i] = countArr.get(countArr.size() - 1 - i);
                    }
                    cdx += 1 + countArr.size();
                }
                count = 1;
            }
            udx++;
        }
        
        return cdx;
    }
    
    public List<Character> toArr(int i) {
        List<Character> res = new ArrayList<>();
        int base = 10;
        while (i > 0) {
            int val = i % base;
            res.add((char)(val + '0'));
            i /= base;
        }
        return res;
    }
}