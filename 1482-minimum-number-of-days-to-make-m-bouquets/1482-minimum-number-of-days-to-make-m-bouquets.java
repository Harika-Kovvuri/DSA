class Solution {
    public boolean possible(int[] bloomDay, int day, int bouquets, int flowers) {
        int cnt = 0;
        int noOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                noOfBouquets += (cnt / flowers);
                cnt = 0;
            }
        }
        noOfBouquets += (cnt / flowers);

        if (noOfBouquets >= bouquets) {
            return true;
        }
        return false;
    }

    public int findMaxi(int[] bloomDay) {
        int maxi = bloomDay[0];
        for (int num : bloomDay) {
            maxi = Math.max(num, maxi);
        }
        return maxi;
    }

    public int findMini(int[] bloomDay) {
        int mini = bloomDay[0];
        for (int num : bloomDay) {
            mini = Math.min(num, mini);
        }
        return mini;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;
        int low=findMini(bloomDay);
        int high=findMaxi(bloomDay);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if (possible(bloomDay, mid, m, k)) {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}