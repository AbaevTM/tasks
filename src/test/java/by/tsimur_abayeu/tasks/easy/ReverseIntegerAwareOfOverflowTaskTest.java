package by.tsimur_abayeu.tasks.easy;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ReverseIntegerAwareOfOverflowTaskTest {

    private ReverseIntegerAwareOfOverflowTask task = new ReverseIntegerAwareOfOverflowTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(123),
                is(321)
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(-123),
                is(-321)
        );
    }

    @Test
    public void test_provided_3() {
        assertThat(
                task.solve(120),
                is(21)
        );
    }

    @Test
    public void test_provided_4() {
        assertThat(
                task.solve(0),
                is(0)
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(Integer.MAX_VALUE),
                is(0)
        );
    }
}