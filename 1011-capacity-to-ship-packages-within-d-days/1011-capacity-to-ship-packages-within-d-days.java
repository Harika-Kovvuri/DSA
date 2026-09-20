class Solution {
    public int findMax(int[] nums){
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            maxi=Math.max(num,maxi);
        }
        return maxi;
    }

    public int findTotal(int[] nums){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
    public boolean canDoInDays(int[] weights,int capacity,int days){
        int noOfDays=1;
        int capacitySum=0;
        for(int i=0;i<weights.length;i++){
            if(capacitySum+weights[i]<=capacity){
                capacitySum+=weights[i];
            }else{
                noOfDays++;
                capacitySum=weights[i];
            }
        }
        return noOfDays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=findMax(weights);
        int high=findTotal(weights);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canDoInDays(weights,mid,days)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}