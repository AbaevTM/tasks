package by.abaevtm.tasks.easy;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class IntPalindromeTest {

    private IntPalindromeTask task = new IntPalindromeTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(121),
                is(true)
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(-121),
                is(false)
        );
    }

    @Test
    public void test_provided_3() {
        assertThat(
                task.solve(10),
                is(false)
        );
    }

    @Test
    public void test_provided_4() {
        assertThat(
                task.solve(-101),
                is(false)
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(2147227412),
                is(true)
        );
    }

    @Test
    public void test_custom_2() {
        assertThat(
                task.solve(1000021),
                is(false)
        );
    }
}