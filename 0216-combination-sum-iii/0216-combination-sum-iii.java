class Solution {
    public void fun(int num, int size, int tgt, List<List<Integer>> ans, List<Integer> sub) {
        if (size == 0) {
            if (tgt == 0) {
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        for (int i = num; i <= 9; i++) {
            if (i > tgt)
                break;
            sub.add(i);
            fun(i + 1, size - 1, tgt - i, ans, sub);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        fun(1, k, n, ans, sub);
        return ans;
    }
}