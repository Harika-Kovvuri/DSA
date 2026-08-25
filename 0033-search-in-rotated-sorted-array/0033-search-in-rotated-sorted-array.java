class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            // left sorted array
            // and check whether the tsrget is in the sorted range
            else if(nums[low]<=nums[mid]){
                if(target<=nums[mid] && target >=nums[low]){
                    high = mid-1;
                }else{
                    low=mid+1;
                }
            }
            else{
                // right sorted array
                if(target>=nums[mid] && target <=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}