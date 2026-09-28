class Solution {
    public void fun(int index, String digits, String[] map, List<String> ans, StringBuilder sub) {
        if (index == digits.length()) {
            ans.add(sub.toString());
            return;
        }
        String letters = map[digits.charAt(index) - 1 - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sub.append(letters.charAt(i));
            fun(index + 1, digits, map, ans, sub);
            sub.deleteCharAt(sub.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = {
                "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        StringBuilder sub = new StringBuilder();
        fun(0, digits, map, ans, sub);
        return ans;
    }
}