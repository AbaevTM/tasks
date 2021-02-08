package by.tsimur_abayeu.tasks.easy;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TwoSumTaskTest {

    private TwoSumTask task = new TwoSumTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(
                        new int[] { 2, 7, 11, 15 },
                        9),
                is(
                        Set.of(0, 1)));
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(
                        new int[] { 3, 2, 4 },
                        6),
                is(
                        Set.of(1, 2)));
    }

    @Test
    public void test_provided_3() {
        assertThat(
                task.solve(
                        new int[] { 3, 3 },
                        6),
                is(
                        Set.of(0, 1)));
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(
                        new int[] { 3, 3, -45, -700, 33, 55, 123, -100 },
                        -800),
                is(
                        Set.of(3, 7)));
    }
}