class Solution {
    public int binarySearch(int[] arr, int tgt) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == tgt) {
                return mid;
            } else if (arr[mid] > tgt) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target) != -1) {
                return true;
            }
        }
        return false;
    }
}