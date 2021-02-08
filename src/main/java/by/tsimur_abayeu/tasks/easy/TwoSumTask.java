package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;
import by.tsimur_abayeu.tasks.TaskCannotBeSolvedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Time complexity : O(n) Space complexity : O(n)
 * <p>
 * One pass with hash map
 */
public class TwoSumTask implements Task {

    @Override
    public Object solve(Object... arguments) {
        int[] result = twoSum((int[]) arguments[0], (int) arguments[1]);
        return Set.of(result[0], result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap();
        int num = 0;
        Integer indexFromMap = null;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            indexFromMap = valueToIndex.get(target - num);
            if (indexFromMap != null) {
                return new int[] { i, indexFromMap };
            }
            valueToIndex.put(num, i);
        }
        throw new TaskCannotBeSolvedException();
    }
}