class Solution {
    public int lowerbound(int[] nums,int target){
        // Lower bound = index of the first element ≥ target
        int low=0;
        int high=nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int upperbound(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans = nums.length;
        // Upper bound = index of the first element > target
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerbound(nums,target);
        int ub = upperbound(nums,target);
        // Lower bound tells me where the target SHOULD be; I still have to check whether it's actually there.

        // nums = [1, 2, 4, 5]
        // target = 3
        if(lb!=-1 && nums[lb]==target){
            return new int[]{lb,ub-1};
        }
        return new int[]{-1,-1};
    }
}