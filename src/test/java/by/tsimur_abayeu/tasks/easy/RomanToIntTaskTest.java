package by.tsimur_abayeu.tasks.easy;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RomanToIntTaskTest {

    private RomanToIntTask task = new RomanToIntTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve("III"),
                is(3)
        );
    }

    @Test
    public void test_provided_2() {
        assertThat(
                task.solve("IX"),
                is(9)
        );
    }

    @Test
    public void test_provided_3() {
        assertThat(
                task.solve("LVIII"),
                is(58)
        );
    }

    @Test
    public void test_provided_4() {
        assertThat(
                task.solve("MCMXCIV"),
                is(1994)
        );
    }
}