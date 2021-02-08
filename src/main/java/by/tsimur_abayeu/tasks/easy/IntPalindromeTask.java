package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;


/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class IntPalindromeTask implements Task {

    @Override
    public Object solve(Object... args) {
        return isPalindromeV2((int) args[0]);
    }

    /**
     * Time complexity : O(logN) Space complexity : O(1)
     * <p>
     * TC is actually better than O(1) for v1 as there we walk for the half of digits log10N/2 whereas in v1 we walk
     * twice each time max predicted number of digits
     *
     * @param x
     * @return
     */
    public boolean isPalindromeV2(int x) {
        // Declining negative values and ones that end with 0 but not 0 : 0220 is not a palindrome as first digit is 2
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0 || (x % 10 == 0)) {
            return false;
        }
        // Try start from the right and as we don't know the position at which first valuable digit on the left comes,
        // just use (leftPart > rightPart)
        // as a predicate to catch situation when values on the left are 0s :  0000123|321
        int leftPart = x;
        int rightPartReversed = 0;
        int devider = 10;
        while (leftPart > rightPartReversed) {
            rightPartReversed = rightPartReversed * 10 + (leftPart % 10);
            if (rightPartReversed == leftPart) {
                // to handle case with odd number of digits we should stop before going through the middle digit
                return true;
            }
            leftPart /= 10;
            devider *= 10;
        }
        return leftPart == rightPartReversed;
    }

    /**
     * Time complexity : O(1) Space complexity : O(1)
     * <p>
     * Two passes : over digits knowing that we are limited by 10 digits per int, second over digits for final check
     * <p>
     * UPD : actually 0(1) is pretty high in that case. As number of digits is ~ log10N <= for integer it looks not
     * significant as we have only 10 digits but O(logN) is more desirable in this case.
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
        //     [0, 0, 0, 0, 0, 0, 0, 2, 1, 2]

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