class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            }
        }
        int ans = -1;
        int maxFreq = 0;
        for (int key : mpp.keySet()) {
            int freq = mpp.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                ans = key;
            } else if (freq == maxFreq && key < ans) {
                ans = key;
            }
        }
        return ans;
    }
}