package fastnslowpointers;

import linkedlists.SingleNode;

public class DetectCycles {

    public static boolean isCyclicLinkedList(SingleNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SingleNode slow = head;
        SingleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
