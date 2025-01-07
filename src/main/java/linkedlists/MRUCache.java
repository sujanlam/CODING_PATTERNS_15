package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class MRUCache {

    DoubleNode head;
    DoubleNode tail;
    int capacity;
    Map<Integer, DoubleNode> capMap;

    MRUCache(int capacity){
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
            removeFromHead(node);
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
            removeFromHead(dNode);
        }
        //if the size is equal to capacity, remove the node from tail
        if(capMap.size() == capacity){
            removeFromHead(dNode);
        }
        //No matter what, it needs to be added; add it to the head
        addToFront(dNode);
    }

    private void removeFromHead(DoubleNode dNode) {
        dNode.prev.next = dNode.next;
        dNode.next.prev = dNode.prev;
        capMap.remove(dNode.key);
    }

    private void addToFront(DoubleNode dNode) {
        dNode.prev = head;
        dNode.next = head.next;
        head.next = dNode;
        head.next.prev = dNode;
        capMap.put(dNode.key, dNode);
    }
}
