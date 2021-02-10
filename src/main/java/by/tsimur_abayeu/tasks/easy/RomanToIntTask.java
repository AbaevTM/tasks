package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;

import java.util.Map;


/**
 * https://leetcode.com/problems/roman-to-intege
 * <p>
 * Time complexity : O(n) where n - length of the string; Space complexity : O(1)
 * <p>
 * Single pass with runner to check cases like IX, DM, etc.
 */
public class RomanToIntTask implements Task {

    private static final Map<Character, Integer> CHAR_TO_SCORE = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    @Override
    public Object solve(Object... args) {
        return romanToInt((String) args[0]);
    }

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        int scoreI;
        int scoreJ;
        for (int i = 0, j = 1; i < length; i++, j++) {
            scoreI = CHAR_TO_SCORE.get(s.charAt(i));
            if (j != length) {
                scoreJ = CHAR_TO_SCORE.get(s.charAt(j));
                if (scoreI < scoreJ) {
                    result -= scoreI;
                    result += scoreJ;
                    i++;
                    j++;
                    continue;
                }
            }
            result += scoreI;
        }
        return result;
    }
}