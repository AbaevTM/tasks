package by.abaevtm.tasks.easy;

import by.abaevtm.tasks.Task;


/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class IntPalindromeTask implements Task {

    @Override
    public Object solve(Object... args) {
        return isPalindromeV2((int) args[0]);
    }

    public boolean isPalindromeV2(int x) {
        return false;
    }

    /**
     * Time complexity : O(1) Space complexity : O(1)
     * <p>
     * Two passes : over digits knowing that we are limited by 10 digits per int, second over digits for final check
     * <p>
     * UPD : actually 0(1) is pretty high in that case. As number of digits is ~ log10N <= for integer it looks cool on
     * paper but O(logN) is more desirable in this case.
     * <p>
     * Also with unbounded types like {@link java.math.BigDecimal} the idea is not working completely.
     *
     * @param x
     * @return
     */
    public boolean isPalindromeV1(int x) {
        // Quickly decline all negative numbers
        if (x < 0) {
            return false;
        }

        int[] digits = new int[10];
        int currentDigit = 0;
        int reminder = x;
        // First pass - get digits
        //     2,147,227,412
        for (int i = 0, devider = 1000 * 1000 * 1000; i < digits.length; i++, devider /= 10) {
            currentDigit = reminder / devider;
            digits[i] = currentDigit;
            reminder -= currentDigit * devider;
        }
        //     [2, 1, 4, 7, 2, 2, 7, 4, 1, 2]

        // Second pass over digits - check digits
        int pointerRight = digits.length - 1;
        for (int pointerLeft = 0; pointerLeft <= pointerRight; pointerLeft++) {
            if (digits[pointerLeft] != 0 || pointerRight != digits.length - 1) {
                if (digits[pointerLeft] != digits[pointerRight]) {
                    return false;
                } else {
                    pointerRight--;
                }
            }
        }
        return true;
    }
}