package com.dan.leetcode.problem0008;

class Solution2 {
    public int myAtoi(String s) {
        // step 1: trim spaces
        String string = s.trim();

        // handle empty string
        if (string.isEmpty())
            return 0;

        int i = 0;
        boolean isNegative = false;

        // step 2: check for - or + sign
        if (string.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (string.charAt(i) == '+') {
            i++;
        }

        // step 3: convert string to number
        int result = 0;
        while (i < string.length()) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            int digit = c - '0';

            // step 4: check overflow
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = result * 10 + digit;
            i++;
        }
        return isNegative ? -result : result;
    }
}