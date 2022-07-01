class Solution {
    public int[] countBits(int num) {
        int [] bit_counts = new int[num +1];
        for(int i=1; i<=num; ++i)
            bit_counts[i] = bit_counts[i>>1] +i%2;
        return bit_counts;
        
    }
        
}