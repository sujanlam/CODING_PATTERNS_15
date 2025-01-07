package linkedlists;

import java.util.HashSet;
import java.util.Set;

public class IntersectOnLinkedList {

    public SingleNode getIntersectionNodeOptimized(SingleNode headA, SingleNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        SingleNode currA = headA;
        SingleNode currB = headB;

        while(currA != currB){
            currA = (currA == null) ? currB: currA.next;
            currB = (currB == null) ? currA: currB.next;
        }

        return currB;
    }

    public SingleNode getIntersectionNode(SingleNode headA, SingleNode headB) {
        Set<SingleNode> setHeadA = new HashSet<>();

        while(headA != null){
            setHeadA.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(setHeadA.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
