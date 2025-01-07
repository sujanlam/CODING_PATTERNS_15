package fastnslowpointers;

import linkedlists.SingleNode;

public class FindMiddleOfLinkedList {

    public static SingleNode getMiddleNode(SingleNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        SingleNode slow = head;
        SingleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
