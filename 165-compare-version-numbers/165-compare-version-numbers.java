class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        
        for (int i = 0, j = 0; i < v1.length || j < v2.length;)
        {
            int rev1 = (i < v1.length ? Integer.parseInt(v1[i++]) : 0);
            int rev2 = (j < v2.length ? Integer.parseInt(v2[j++]) : 0);
            
            if (rev1 > rev2)
                return 1;
            else if (rev2 > rev1)
                return -1;
        }
        
        return 0;
    }
}