class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            ans=Math.max(sum,ans);
            //if negative sum don't take it will never give us max
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}