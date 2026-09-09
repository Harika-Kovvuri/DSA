class Solution {
    public int findmax(int[] bloomday) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < bloomday.length; i++) {
            maxi = Math.max(maxi, bloomday[i]);
        }
        return maxi;
    }

    public int findmini(int[] bloomday) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < bloomday.length; i++) {
            mini = Math.min(mini, bloomday[i]);
        }
        return mini;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int noOfBouqets = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                noOfBouqets += (count / k);
                count = 0;
            }
        }
        noOfBouqets += (count / k);
        if (noOfBouqets >= m) {
            return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * (long) k > (long) bloomDay.length)
            return -1;
        int high = findmax(bloomDay);
        int low = findmini(bloomDay);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }
}