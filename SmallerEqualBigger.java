import sun.awt.image.ImageWatched;

public class SmallerEqualBigger {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode sort(LinkedListNode head, int key) {
        LinkedListNode small = null;
        LinkedListNode equal = null;
        LinkedListNode big = null;
        LinkedListNode cur = head;
        while (cur != null) {
            LinkedListNode next = cur.next;
            if (cur.value < key) {
                small = insertNode(small, cur);
            } else if (cur.value == key) {
                equal = insertNode(equal, cur);
            } else {
                big = insertNode(big, cur);
            }
            cur = next;
        }
        small = mergeTwoLinkedList(small, equal);
        return small == null ? big : mergeTwoLinkedList(small, big);
    }

    public static LinkedListNode insertNode(LinkedListNode head, LinkedListNode cur) {
        if (head == null) {
            head = cur;
            head.next = null;
        } else {
            LinkedListNode end = head;
            while (end != null) {
                if (end.next == null) {
                    end.next = cur;
                    cur.next = null;
                }
                end = end.next;
            }
        }
        return head;
    }

    public static LinkedListNode mergeTwoLinkedList(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        LinkedListNode cur = list1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = list2;
        return list1;
    }

    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(9);
        head1.next = new LinkedListNode(0);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(3);
        head1.next.next.next.next = new LinkedListNode(5);
        head1.next.next.next.next.next = new LinkedListNode(6);

        printOutCome(sort(head1, 3));
    }
}
