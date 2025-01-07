package linkedlists;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public SingleNode reverseList(SingleNode head) {

        SingleNode current = head;
        SingleNode prev = null;
        SingleNode next = null;
        while (current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public SingleNode reverseListRecursion(SingleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SingleNode restReversed = reverseListRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return restReversed;
    }
}
