class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
        int degree = 0;
        for (int freq : mpp.values()) {
            degree = Math.max(degree, freq);
        }
        int ans = Integer.MAX_VALUE;
        HashMap<Integer,Integer> first=new HashMap<>();
        HashMap<Integer,Integer> last=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int num=nums[i];
            // first occurence
            if(!first.containsKey(num)){
                first.put(num,i);
            }
            last.put(num,i);
            // sometimes it can be single element also
        }
        for(int num:mpp.keySet()){
            if(mpp.get(num) == degree){
                int len = last.get(num)-first.get(num)+1;
                ans=Math.min(ans,len);
            }
        }
        return ans;
    }
}