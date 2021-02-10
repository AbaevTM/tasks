package by.tsimur_abayeu.tasks.easy;


import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class LongestCommonPrefixTest {

    private LongestCommonPrefixTask task = new LongestCommonPrefixTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(of("flower", "flow", "flight")),
                is("fl")
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(of("dog", "racecar", "car")),
                is("")
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(of("a")),
                is("a")
        );
    }

    @Test
    public void test_custom_2() {
        assertThat(
                task.solve(of("a", "ab")),
                is("a")
        );
    }

    @Test
    public void test_custom_3() {
        assertThat(
                task.solve(of("", "")),
                is("")
        );
    }
}