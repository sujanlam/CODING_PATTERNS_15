package sortings;


import linkedlists.SingleNode;

public class SortLinkedList {
    public SingleNode sortLinkedList(SingleNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //Split a linked list to 2
        SingleNode secondHead = splitLinkedList(head);
        //sort first half recursively
        SingleNode firstHalfSorted = sortLinkedList(head);
        //sort second half recursively
        SingleNode secondHalfSorted = sortLinkedList(secondHead);

        //merge them together
        return mergeTwoHalves(firstHalfSorted, secondHalfSorted);
    }

    private SingleNode mergeTwoHalves(SingleNode l1, SingleNode l2) {
        SingleNode dummy = new SingleNode(0);
        SingleNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                current.next= l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            if(l1 != null){
                current.next = l1;
            }else {
                current.next = l2;
            }
        }
        return dummy.next;
    }

    private SingleNode splitLinkedList(SingleNode head) {
        SingleNode fast = head;
        SingleNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        SingleNode secondHead = slow.next;
        slow.next = null;
        return secondHead;
    }
    // Utility method to print the linked list
    public static void printList(SingleNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
        SingleNode head = new SingleNode(4);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(1);
        head.next.next.next = new SingleNode(3);

        System.out.println("Original List:");
        printList(head);

        SortLinkedList sorter = new SortLinkedList();
        SingleNode sortedHead = sorter.sortLinkedList(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }

}
