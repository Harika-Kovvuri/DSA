class Solution {
    public void fun(int index, int sum, int[] nums, int tgt, List<Integer> sub, List<List<Integer>> ans) {
        if (index == nums.length) {
            if (sum == tgt) {
                ans.add(new ArrayList<>(sub));
            }
            return;
        }

        if (sum + nums[index] <= tgt) {
            sub.add(nums[index]);
            sum = sum+nums[index];
            fun(index, sum, nums, tgt, sub, ans);
            sum = sum-nums[index];
            sub.remove(sub.size() - 1);
        }

        fun(index + 1, sum, nums, tgt, sub, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        fun(0, 0, candidates, target, sub, ans);
        return ans;
    }
}