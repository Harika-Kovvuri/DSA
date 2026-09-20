class Solution {
    public int findMax(int[] nums){
        int maxi=nums[0];
        for(int num:nums){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }

    public int sum(int[] nums, int divisor){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=Math.ceil((double)nums[i]/(double)divisor);
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=findMax(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sum(nums,mid)<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}