class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int n : nums) {
            if (n % 2 == 1)
                set.add(2 * n);
            else
                set.add(n);
        }

        int deviation = Integer.MAX_VALUE;
        while (true) {
            int max_val = set.last();
            deviation = Math.min(deviation, max_val - set.first());
            if (max_val % 2 == 1) {
                break;
            } else {
                set.remove(max_val);
                set.add(max_val / 2);
            }
        }
        return deviation;
    }
}