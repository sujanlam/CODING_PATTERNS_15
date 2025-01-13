package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class CombineSortedLinkedList {
    public static ListNode merge3LinkedLists(ListNode list1, ListNode list2, ListNode list3){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        if(list1 != null){
            pq.offer(list1);
        }
        if(list2 != null){
            pq.offer(list2);
        }
        if(list3 != null){
            pq.offer(list3);
        }

        while (!pq.isEmpty()){
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }
    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to create a linked list from an array
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create three sorted linked lists
        ListNode list1 = createList(new int[] {1, 4, 5});
        ListNode list2 = createList(new int[] {1, 3, 4});
        ListNode list3 = createList(new int[] {2, 6});

        // Merge the three lists
        ListNode mergedList = merge3LinkedLists(list1, list2, list3);

        // Print the merged list
        System.out.print("Merged list: ");
        printList(mergedList);
    }
}