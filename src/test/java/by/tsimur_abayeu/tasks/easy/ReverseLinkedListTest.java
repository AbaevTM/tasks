package by.tsimur_abayeu.tasks.easy;


import by.tsimur_abayeu.tasks.easy.ReverseLinkedListTask.ListNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;


public class ReverseLinkedListTest {

    private ReverseLinkedListTask task = new ReverseLinkedListTask();

    @Test
    public void test_provided_1() {
        assertThat(
                task.solve(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                is(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))
        );
    }

    @Test
    public void test_custom_1() {
        assertThat(
                task.solve(new ListNode(1)),
                is(new ListNode(1))
        );
    }

    @Test
    public void test_custom_2() {
        assertThat(
                task.solve(null, null),
                is(nullValue())
        );
    }

}