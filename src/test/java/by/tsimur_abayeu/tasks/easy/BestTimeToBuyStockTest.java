package by.tsimur_abayeu.tasks.easy;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BestTimeToBuyStockTest {

    private BestTimeToBuyStockTask task = new BestTimeToBuyStockTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(new int[] { 7, 1, 5, 3, 6, 4 }),
                is(5)
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve(new int[] { 7, 6, 4, 3, 1 }),
                is(0)
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(new int[] { 7, 6, 5, 4, 3 }),
                is(0)
        );
    }

    @Test
    public void test_custom_2() {
        assertThat(
                task.solve(new int[] { 1, 2, 3, 4, 5 }),
                is(4)
        );
    }

    @Test
    public void test_custom_3() {
        assertThat(
                task.solve(new int[] { 7, 6, 5, 4, 3, 10, 12 }),
                is(9)
        );
    }
}