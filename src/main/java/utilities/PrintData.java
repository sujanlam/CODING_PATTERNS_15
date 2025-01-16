package utilities;

import linkedlists.SingleNode;

public class PrintData {

        public static void printArray(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        public static void printLinkedList(SingleNode head) {
            SingleNode current = head;
            while (current != null) {
                System.out.print(current.next + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        public static void printDoubleDimArray(int[][] arr){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
