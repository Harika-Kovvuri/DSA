class Solution {
    public void fun(int ind,int[] nums,List<List<Integer>>ans,List<Integer>sub){
        ans.add(new ArrayList<>(sub));
        for(int i=ind;i<nums.length;i++){
            if(i>ind &&nums[i]==nums[i-1]) continue;
            sub.add(nums[i]);
            fun(i+1,nums,ans,sub);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer>sub=new ArrayList<>();
        fun(0,nums,ans,sub);
        return ans;    
    }
}