class Solution
{
    public int bitwiseComplement(int num)
    {
        for (int i = 31; i >= 0; i--)
        {
            if ((num & 1 << i) != 0 || i == 0)
            {
                for (int j = i; j >= 0; j--)
                    num = (num ^ 1 << j);
                
                break;
            }
        }
        
        return num;
    }
}