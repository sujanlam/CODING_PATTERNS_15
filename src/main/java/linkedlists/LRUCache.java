package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    DoubleNode head;
    DoubleNode tail;
    int capacity;
    Map<Integer, DoubleNode> capMap;

    LRUCache(int capacity){
        this.capacity = 4;
        this.head = new DoubleNode(0,0);
        this.tail = new DoubleNode(0,0);
        this.capMap = new HashMap<>();
        head.next = tail;
        tail.prev=head;
    }
    public int get(int key){
        if(capMap.containsKey(key)){
            //remove that node
            DoubleNode node = capMap.get(key);
            removeFromTail(node);
            //add that to the front
            addToFront(node);
            //return that node
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        DoubleNode dNode = new DoubleNode(key, value);
        //if it is present in the map, remove that from the map
        if(capMap.containsKey(key)){
            removeFromTail(dNode);
        }
        //if the size is equal to capacity, remove the node from tail
        if(capMap.size() == capacity){
            removeFromTail(dNode);
        }
        //No matter what, it needs to be added; add it to the head
        addToFront(dNode);
    }

    private void removeFromTail(DoubleNode dNode) {
        capMap.remove(dNode.key);
        dNode.prev.next = dNode.next;
        dNode.next.prev = dNode.prev;
    }

    private void addToFront(DoubleNode dNode) {
        capMap.put(dNode.key, dNode);
        dNode.prev = head;
        dNode.next = head.next;
        head.next = dNode;
        head.next.prev = dNode;
    }
}
