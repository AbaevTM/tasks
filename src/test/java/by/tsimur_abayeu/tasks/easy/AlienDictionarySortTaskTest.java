package by.tsimur_abayeu.tasks.easy;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class AlienDictionarySortTaskTest {

    private AlienDictionarySortTask task = new AlienDictionarySortTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"),
                is(true)
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"),
                is(false)
        );
    }

    @Test
    public void test_provided_3() {
        assertThat(
                task.solve(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"),
                is(false)
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(new String[] { "abc", "abcd", "bbb", "bbbc", "bbbd" }, "abcdefghijklmnopqrstuvwxyz"),
                is(true)
        );
    }
}