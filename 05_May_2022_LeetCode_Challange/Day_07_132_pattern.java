class Solution {
    public boolean find132pattern(int[] nums) {
    
        if(nums==null||nums.length<3) return false;
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        min[0]=nums[0];
        max[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=max[i-1]){
                max[i]=nums[i];
                min[i]=min[i-1];
            }
            else if(nums[i]<=min[i-1]){
                min[i]=nums[i];
                max[i]=max[i-1];
            }
            else{
                int j=0;
                for( j=i-1;j>=1;j--){
                    if(nums[j]>nums[i])
                        break;
                }
                if(j>=1&&min[j-1]<nums[i])
                    return true;
                max[i]=max[i-1];
                min[i]=min[i-1];
            }
        }
        return false;
    }
    }