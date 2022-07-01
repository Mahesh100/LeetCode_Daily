class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        /*
        
        k=2
        00
        01
        10
        11
        
        
        s=00110110 => True
        
        Approach 
        Generate all the binary representation of length k and then check in strign that 
        whether that binary representations contains or not, but it is too costly and bruteforce 
        solution
        
        Another way we can do is, we can cut all the substrings and generate all the substrings from s
        
       s= 00110110
        i=2 this means we wiil generate all the substrings of length 2
        
        Which are 00,01,10,,11,10
        and if we save all the above sustrings in set then duplicate string will be removed
        
        which are 00,01,10,11  which are total 4 strings and is equal to 2^2  (2^k)
        
        And simple using sliding window we can create all the substrings of length k

        */
        
        //Here we are using set for holding our all the substrings
        
        Set<String> set = new HashSet();
        
        for (int i =0; i<=s.length()-k; i++){    //Beacuse still max k we can  generate n-k+1 substrings
            set.add(s.substring(i, i+k));            
            
        }
        
        //In the end we just simply return 
        
        return set.size() == Math.pow(2,k);
        
    }
}
