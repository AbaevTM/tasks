package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;

import java.util.List;


/**
 * https://leetcode.com/problems/longest-common-prefix
 * <p>
 * Time complexity : O(n*m) where n - number of strings; m - size of minimal prefix Space complexity : O(1)
 * <p>
 * Vertical scan. Other approaches look more complex and some of them has more not needed comparisons.
 * <p>
 * But if you need it to be executed multiple times there's nice idea about using trie : at the end of :
 * https://leetcode.com/problems/longest-common-prefix/solution/
 * 
 */
public class LongestCommonPrefix implements Task {

    @Override
    public Object solve(Object... args) {
        return longestCommonPrefix(((List<String>) args[0]).toArray(new String[0]));
    }

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs != null && strs.length != 0) {
            char currentChar;
            int i;
            for (i = 0; i < strs[0].length(); i++) {
                currentChar = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || currentChar != strs[j].charAt(i)) {
                        return result = strs[j].substring(0, i);
                    }
                }
            }
            return result = strs[0].substring(0, i);
        }
        return result;
    }
}