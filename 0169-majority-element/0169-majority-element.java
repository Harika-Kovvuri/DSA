class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (mpp.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}