package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;


/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary
 * <p>
 * Time complexity : O(c) where c is number of characters in all strings provided | Space complexity : O(1)
 */
public class AlienDictionarySortTask implements Task {

    @Override
    public Object solve(Object... args) {
        return isAlienSorted((String[]) args[0], (String) args[1]);
    }

    public boolean isAlienSorted(String[] words, String order) {
        // As we now all values in order string, know size and that values has 1x1 mapping to position
        // initial idea to use HashMap for mapping may be improved.
        // Instead let's use array of values like [3, 2, 1, 0, ...] for order "dcba..."
        // To get order of the character later - get value from the array by index as diff (character, 'a')
        int[] orderMap = populateOrderMap(order);
        for (int i = 0, j = 1; i < words.length - 1; i++, j++) {
            if (!compareWords(words[i], words[j], orderMap)) {
                return false;
            }

        }
        return true;
    }

    private int[] populateOrderMap(String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        return orderMap;
    }

    private boolean compareWords(String word, String anotherWord, int[] orderMap) {
        int i = 0;
        char charFromWord;
        char charFromAnotherWord;
        while (i < word.length() && i < anotherWord.length()) {
            charFromWord = word.charAt(i);
            charFromAnotherWord = anotherWord.charAt(i);
            if (charFromWord != charFromAnotherWord) {
                return orderMap[charFromWord - 'a'] < orderMap[charFromAnotherWord - 'a'];
            }
            i++;
        }
        // If all characters are equal for min length, check for case that "abc(de..)" is always bigger than "abc"
        return word.length() <= anotherWord.length();
    }

}