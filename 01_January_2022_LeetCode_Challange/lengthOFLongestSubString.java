class Solution {
    public static int lengthOfLongestSubstring(String s) {
        
        int n= s.length();
        
        //Result 
        int res =0;
        
        for(int i=0; i<n; i++){
            
            boolean[] visited = new boolean[256];
            
            for(int j=i; j<n; j++){
                
                //if current character is visited 
                //Break the loop
                
                if(visited[s.charAt(j)]==true)
                    break;
                
                //Else Update the result if
                //this window is larger, and mark
                //current character as visited
                else{
                    res =Math.max(res, j-i+1);
                    visited[s.charAt(j)]=true;
                    
                }
            }
            
            //Remove the first character of previous
            //Window
        }
        
        return res;  
    }
    
    //Driver code
    public static void main(String [] args){
        String s= "abcabcbc";
        System.out.println("The input of String is "+s);
        
        int len =lengthOfLongestSubstring(s);
        System.out.println(+len);
                           
    }
}
