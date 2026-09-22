class Solution {
    public int findMax(int[] arr){
        int maxi=Integer.MIN_VALUE;
        for(int num:arr){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
    public int findSum(int[] arr){
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        return sum;
    }
    public boolean canAllocate(int[] books, int pagesReqd,int k){
        int allocatedStudents=1;
        int pages=0;
        for(int i=0;i<books.length;i++){
            if(books[i]>pagesReqd) return false;
            if(books[i]+pages > pagesReqd){
                allocatedStudents++;
                pages=books[i];
            }else{
                pages+=books[i];
            }
            if(allocatedStudents>k){
                return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low=findMax(nums);
        int high=findSum(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAllocate(nums,mid,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}