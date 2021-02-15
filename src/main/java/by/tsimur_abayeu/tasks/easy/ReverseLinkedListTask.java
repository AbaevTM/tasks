package by.tsimur_abayeu.tasks.easy;

import by.tsimur_abayeu.tasks.Task;

import java.util.Objects;


/**
 * https://leetcode.com/problems/reverse-linked-list
 * <p>
 * 1) Recursive Time complexity : O(n) | Space complexity : O(n) - we should include as well memory used for thread
 * stack
 * <p>
 * 2) Iterative Time complexity : O(n) | Space complexity : O(1)
 */
public class ReverseLinkedListTask implements Task {

    @Override
    public Object solve(Object... args) {
        return reverseRecursive((ListNode) args[0]);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    private ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode reverseIterative(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = null;
        ListNode nextNode = head;
        ListNode realNext;
        while (nextNode != null) {
            realNext = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = realNext;
        }
        return node;
    }
}