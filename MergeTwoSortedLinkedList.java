import sun.awt.image.ImageWatched;

import java.util.HashMap;

public class MergeTwoSortedLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode mergeNode(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode newhead = head1;
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        LinkedListNode cur = head2;
        while (cur != null) {
            LinkedListNode next = cur.next;
            newhead = InsertNode(newhead, cur);
            cur = next;
        }
        return newhead;
    }

    public static LinkedListNode InsertNode(LinkedListNode headnode, LinkedListNode insertNode) {
        LinkedListNode cur = headnode.next;
        LinkedListNode last = headnode;
        if (last.value >= insertNode.value) {
            insertNode.next = headnode;
            return insertNode;
        }
        while (cur != null) {
            if (last.value < insertNode.value && insertNode.value <= cur.value) {
                break;
            }
            last = cur;
            cur = cur.next;
        }
        last.next = insertNode;
        insertNode.next = cur;
        return headnode;
    }

    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(3);
        head1.next.next = new LinkedListNode(5);
        head1.next.next.next = new LinkedListNode(7);
        head1.next.next.next.next = new LinkedListNode(9);

        LinkedListNode head2 = new LinkedListNode(0);
        head2.next = new LinkedListNode(2);
        head2.next.next = new LinkedListNode(3);
        head2.next.next.next = new LinkedListNode(7);
        printOutCome(mergeNode(head1, head2));
    }
}
