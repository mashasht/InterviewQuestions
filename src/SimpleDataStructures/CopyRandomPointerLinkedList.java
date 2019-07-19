package SimpleDataStructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashashtutman on 2019-05-07.
 */
public class CopyRandomPointerLinkedList {
    class Node {
        int val;
        Node next;
        Node random;

        Node() {}

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        Node(Node other) {
            this.val = other.val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomPointerLinkedList(Node head) {
        if (head == null) {
            return head;
        }
        Node current = head;

        Node copyHead = new Node(head);
        Node copy = copyHead;
        Map<Node, Node> nodes = new HashMap<>();
        Node previous = null;
        while(current != null) {
            if (previous != null){
                previous.next = copy;
            }
            nodes.put(current, copy);
            previous = current;
            current = current.next;
            copy = new Node(current);
        }
        current = head;
        while(current != null) {
            nodes.get(current).random = nodes.get(current.random);
            current = current.next;
        }
        return copyHead;
    }
}
