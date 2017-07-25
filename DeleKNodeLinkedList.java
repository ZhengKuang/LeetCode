import java.util.Stack;

public class DeleKNodeLinkedList {
    public static Stack<LinkedListNode> nodeStack = new Stack<>();

    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            value = data;
        }
    }

    public static void DeletedKNode(int k, LinkedListNode head) {
        LinkedListNode reverseK = head;
        while (reverseK != null) {
            nodeStack.push(reverseK);
            reverseK = reverseK.next;
        }
        int aimK = k;
        while (aimK != 0) {
            reverseK = nodeStack.pop();
            aimK--;
        }
        if (k == 1) {
            nodeStack.pop().next = null;
        } else {
            if (!nodeStack.isEmpty()) {
                nodeStack.pop().next = reverseK.next;
            } else {
                head = reverseK.next;
            }
        }
        printOutCome(head);
    }

    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static LinkedListNode getNextK(int k, LinkedListNode node) {
        while (k != 0) {
            node = node.next;
        }
        return node;
    }

    public static void main(String args[]){
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(4);
        head1.next.next.next = new LinkedListNode(5);
        head1.next.next.next.next = new LinkedListNode(8);

        DeletedKNode(5,head1);
    }

}
