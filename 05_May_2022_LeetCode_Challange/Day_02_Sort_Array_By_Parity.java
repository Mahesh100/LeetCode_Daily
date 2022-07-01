
class Solution {
    public int[] sortArrayByParity(int[] A) {
      int i = 0, j = A.length - 1; // 2 pointers
      while (i < j) {
           if (A[i] % 2 > A[j] % 2) { // if both a[i] and a[j]   are in the incorrect positions, then swap
           int tmp = A[i];
           A[i] = A[j];
           A[j] = tmp;
           }
      if (A[i] % 2 == 0) i++; // if a[i] is in correct position, then move the next one
      if (A[j] % 2 == 1) j--; // if a[j] is in the correct position, the move to the next one.
      }
      return A; // array after sorted
}
}