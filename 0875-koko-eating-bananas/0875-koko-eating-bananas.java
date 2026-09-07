class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = 0;
        for (int pile : piles) {
            maxi = Integer.max(pile, maxi);
        }
        int low = 1;
        int high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (fun(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long fun(int[] piles, int hrs) {
        long ans = 0;
        for (int pile : piles) {
            ans += (long) Math.ceil((double) pile / (double) hrs);
        }
        // if (ans <= h) {
        //     return ans;
        // }
        return ans;
    }
}