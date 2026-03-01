package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeLL {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(List.of(1, 2, 3, 4, 5));
        head = removeNthFromEnd(head, 5);

        if (head != null) {
            head.print();
        } else {
            System.out.println("Empty");
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        * Create a method that removes the n-th element from a LL from right to left
        * This approach was using a List and indexing
        * */
        // If there's just one node and I want to delete it, I return null directly
        if (n == 1 && head.next == null) {
            return null;
        }

        // Get the head in a temp variable
        ListNode curr = head;
        // Create a list of nodes
        List<ListNode> nodes = new ArrayList<>();
        // Save all the LL in a List
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        // If it's the first node, we just return the next element
        if (n >= nodes.size()) {
            return head.next;
        }

        // Drop the node from right to left <-
        ListNode node = nodes.get(nodes.size() - 1 - n);
        ListNode nextNode = node.next;
        node.next = node.next.next;
        nextNode.next = null;

        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode createList(List<Integer> values) {
            ListNode head = new ListNode();
            ListNode pointer = head;

            for (int value : values) {
                pointer.next = new ListNode(value);
                pointer = pointer.next;
            }

            return head.next;
        }

        public void print() {
            ListNode head = this;
            while (head != null) {
                System.out.print(head.val + " - > ");
                head = head.next;
            }
        }
    }
}
