package linkedlists;

public class RemoveKthLastNode {
    public static void main(String[] args) {
        int num = 0;
        //sampleMethod(num);
    }

    public SingleNode removeNthFromEnd(SingleNode head, int n) {
        SingleNode dummy = new SingleNode(0);
        dummy.next = head;
        SingleNode first = dummy;
        SingleNode second = dummy;

        for (int i = 0; i < n; i++) {
            if (first == null) { // k > length of th linkedlist.
                return null;
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
