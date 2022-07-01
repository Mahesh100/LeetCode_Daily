import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
 

    public static int search(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++)
            if(nums[i] == target)
                return i;
        return -1;
    }
    
    public static void main(String[] args){
      int nums[] = {4,5,6,7,0,1,2};
      System.out.println(search(nums, 4));
    }
}
