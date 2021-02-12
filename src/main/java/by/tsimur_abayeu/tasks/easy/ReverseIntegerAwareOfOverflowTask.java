package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;


/**
 * https://leetcode.com/problems/reverse-integer
 * <p>
 * Time complexity : O(log(n)) | Space complexity : O(1)
 * <p>
 * One pass through digits with check for overflow on each step
 */
public class ReverseIntegerAwareOfOverflowTask implements Task {

    private static final int INT_MAX_DIVIDED_BY_10 = Integer.MAX_VALUE / 10;

    private static final int INT_MIN_DIVIDED_BY_10 = Integer.MIN_VALUE / 10;

    private static final int INT_MAX_MODULO = Integer.MAX_VALUE % 10;

    private static final int INT_MIN_MODULO = Integer.MIN_VALUE % 10;

    @Override
    public Object solve(Object... args) {
        return reverse((int) args[0]);
    }

    public int reverse(int x) {
        int reminder = x;
        int reversed = 0;
        int modulo = 0;
        while (reminder != 0) {
            modulo = reminder % 10;
            if (aboutToOverflow(reversed, reminder)) return 0;
            reversed = reversed * 10 + modulo;
            reminder /= 10;
        }
        return reversed;
    }

    private boolean aboutToOverflow(int x, int valueToAdd) {
        return (x > INT_MAX_DIVIDED_BY_10)
                || (x == INT_MAX_DIVIDED_BY_10 && valueToAdd > INT_MAX_MODULO)
                || (x < INT_MIN_DIVIDED_BY_10
                || (x == INT_MIN_DIVIDED_BY_10 && valueToAdd < INT_MIN_MODULO));
    }
}