class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cntOfIntervalToBeRemoved = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int freedTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= freedTime) {
                freedTime = interval[1];
            } else {
                cntOfIntervalToBeRemoved++;
            }
        }
        return cntOfIntervalToBeRemoved;
    }
}