/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattenNode(head);
        return head;
    }

    public Node flattenNode(Node head){

        Node current = head;
        Node tail = head;

        while(current != null){
            Node nextNode =  current.next;
            
            if(current.child != null){

                Node childTrail = flattenNode(current.child);

                current.next = current.child;
                current.child.prev = current;

                if(nextNode != null){
                    nextNode.prev = childTrail;
                    childTrail.next = nextNode;
                }

                current.child = null;
                tail = childTrail;

            }else{
                tail = current;
            }

            current = nextNode;
        }

        return tail;
    }
}