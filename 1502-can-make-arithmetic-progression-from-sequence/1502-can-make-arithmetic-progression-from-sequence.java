import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i + 1] - arr[i] != arr[1] - arr[0]) {
                return false;
            }
        }

        return true;
    }
}