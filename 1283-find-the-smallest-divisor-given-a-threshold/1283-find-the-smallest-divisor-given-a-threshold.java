class Solution {
    public int maxim(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }

    int dsum(int[] nums, int div) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) nums[i] / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxim(nums);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (dsum(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}