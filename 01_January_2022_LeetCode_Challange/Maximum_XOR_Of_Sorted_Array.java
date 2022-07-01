
class Solution {
    // First determine the high position, then determine the low (meaning of a little greedy algorithm) to ensure the biggest nature of this question
    //  One will then determine the size of this digit
    //  Utilizing properties: a ^ b = c, then a ^ c = b, and B ^ c = a
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            //  Note 1: Pay attention to the prefix method, Mask is this
            //  Use different or can be Mask = Mask ^ (1 << i);
            mask = mask | (1 << i);
            // System.out.println("mask is " + Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                //  Note 2: Use &, the prefix meaning here (from high to low)
                set.add(num & mask);
            }

            //  Here first assumes that the n-bit is 1, the first N-1 bit RES is previously iterative
            int temp = res | (1 << i);
            System.out.println("temp is " + Integer.toBinaryString(temp));
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}

