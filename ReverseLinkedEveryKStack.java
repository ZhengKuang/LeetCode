import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedEveryKStack {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode(LinkedListNode head, int k) {
        Stack<LinkedListNode> stack = new Stack<>();
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        LinkedListNode cur = head;
        LinkedListNode newHead = null;
        LinkedListNode left = null;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            if (stack.size() == k) {
                newHead=newHead==null?stack.peek():newHead;
                left = reverse(stack, left, cur);
            }
        }
        return newHead;
    }

    public static LinkedListNode reverse(Stack<LinkedListNode> stack, LinkedListNode left, LinkedListNode right) {
        LinkedListNode top = stack.pop();
        if (left != null) {
            left.next = top;
        }
        while (!stack.isEmpty()) {
            LinkedListNode tmp = stack.pop();
            top.next = tmp;
            top = tmp;
        }
        top.next=right;
        return top;
    }


    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(4);
        head1.next.next.next.next = new LinkedListNode(5);
        printOutCome(reverseNode(head1, 5));
    }
}
