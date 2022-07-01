class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int start = 1;
        int end = nums.length;
        while (start < end) {
            int count = 0;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}