class Solution {    
    int [] masks = new int []  {0x80, 0xE0, 0xF0, 0xF8};
    int [] values = new int [] {0x00, 0xC0, 0xE0, 0xF0};
    int endBytesMask = 0xC0;
    int endBytesValue = 0x80;
    
    public boolean validUtf8(int[] data) {
        
        for (int i = 0; i < data.length; i++) {
            int start = data[i];
            
            int size = 0;
            for (size = 0; size < 4; size++)
                if ((start & masks[size]) == values[size])
                    break;
            
            if (size == 4)
                return false;
            else if (size == 0)
                continue;
            
            int end = i + size;
            
            // Not enough bytes
            if (end >= data.length)
                return false;
            
            // Check all data bytes
            while (++i <= end)
                if ((data[i] & endBytesMask) != endBytesValue)
                    return false;
            i--;
        }
        
        return true;
    }
}