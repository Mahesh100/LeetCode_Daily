// Day_3_Shortest_unsorted_continous_subArray

// O(N*logN)time
// O(N)space
public int findUnsortedSubarray(int[] nums) {
    int len = nums.length;
    int[] sort = new int[len];
    int size = 0;
    int s = len;
    int e = 0;
    for (int i = 0; i < len; i++) {
        int insertPos = binarySearch(sort, size, nums[i]);
        size++;
        if (insertPos + 1 == size) {
            continue;
        }
        s = Math.min(insertPos, s);
        e = i;
    }
    return Math.max(e - s + 1, 0);
}

private int binarySearch(int[] arr, int size, int val) {
    int l = 0;
    int r = size;
    while (l < r) {
        int mid = (l + r) >>> 1;
        if (arr[mid] <= val) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    System.arraycopy(arr, l, arr, l + 1, size - l);
    arr[l] = val;
    return l;
}