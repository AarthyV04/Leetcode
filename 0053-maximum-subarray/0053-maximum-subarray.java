class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int currentsum =0;
        for(int num:nums){
            if(currentsum<0){
                currentsum=0;
            }
            currentsum += num;
            maxsum = Math.max(maxsum,currentsum);
        }
        return maxsum;
    }
}