class Solution {
    public int getKthBit(int n, int k) {
        return ((n >> k) & 1);
    }

    public int setKthBit(int n, int k) {
        return (n | (1 << k));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt1 = 0;
            for (int j = 0; j < nums.length; j++) {
                if (getKthBit(nums[j], i) == 1) {
                    cnt1++;
                }
            }
            if (cnt1 % 3 != 0) {
                ans = setKthBit(ans, i);
            }
        }
        return ans;
    }
}