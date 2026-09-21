class Solution {
    public int findKthPositive(int[] arr, int k) {
        // finding the smallest range
        // no.of missing elements at high = arr[high]-(high+1)
        // reqd answer = arr[high]+howmanymore
        // howmanymore=k-missing
        // high+1+k
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfMissing = arr[mid] - (mid + 1);
            if (noOfMissing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + k + 1;
    }
}