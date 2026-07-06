class Solution {
    public boolean isSorted(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                temp[j]=nums[(i+j)%n];
            }
            if(isSorted(temp)){
                return true;
            }
        }
        return false;
    }
}