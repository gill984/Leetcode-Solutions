class Solution {    
    int [] masks = new int []  {0x80, 0xE0, 0xF0, 0xF8};
    int [] values = new int [] {0x00, 0xC0, 0xE0, 0xF0};
    int endBytesMask = 0xC0;
    int endBytesValue = 0x80;
    
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int size = 0;
            for (size = 0; size < 4; size++)
                if ((data[i] & masks[size]) == values[size])
                    break;
            
            if (size == 4)
                return false;
            else if (size == 0)
                continue;
            
            int end = i + size;
            if (end >= data.length)
                return false;
            
            while (++i <= end)
                if ((data[i] & endBytesMask) != endBytesValue)
                    return false;
            i--;
        }
        
        return true;
    }
}