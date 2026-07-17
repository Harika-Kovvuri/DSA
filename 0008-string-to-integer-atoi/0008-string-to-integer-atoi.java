class Solution {

    int helper(String s, int i, int sign, long num) {
        // base case: end or non-digit
        if (i == s.length() || !Character.isDigit(s.charAt(i)))
            return (int) (sign * num);

        int digit = s.charAt(i) - '0';

        // overflow check BEFORE adding digit
        if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        num = num * 10 + digit;
        return helper(s, i + 1, sign, num);
    }

    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip spaces
        while (i < n && s.charAt(i) == ' ')
            i++;

        // 2. Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        // 3. Recursive call
        return helper(s, i, sign, 0);
    }
}