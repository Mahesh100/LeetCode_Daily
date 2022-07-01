class Solution {
    public int compareVersion(String version1, String version2) {
        String [] s1 = version1.split("\\.");
        String [] s2 = version2.split("\\.");
        
        int maxlength =Math.max(s1.length, s2.length);
        for(int i=0; i<maxlength; i++){
            int v1 =i<s1.length ? Integer.parseInt(s1[i]) :0;
            int v2 =i<s2.length ? Integer.parseInt(s2[i]) :0; 
            if(v1>v2)
                return 1;
            else if(v1<v2)
                return -1;
        }
        return 0;
    }
}