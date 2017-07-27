public class ReversedDoubleLinkedList {
    private static class DoubleLinkedList {
        public DoubleLinkedList next;
        public DoubleLinkedList last;
        public int value;

        public DoubleLinkedList(int value) {
            this.value = value;
        }
    }

    public static DoubleLinkedList reverseDouble(DoubleLinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleLinkedList last = null;
        DoubleLinkedList next = null;
        DoubleLinkedList cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            cur.last = next;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void printOutCome(DoubleLinkedList node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        DoubleLinkedList node = new DoubleLinkedList(1);
        node.next = new DoubleLinkedList(2);
        node.next.next = new DoubleLinkedList(3);
        node.next.next.next = new DoubleLinkedList(4);
        node.next.next.next.next = new DoubleLinkedList(5);

        node.next.next.next.next.last = node.next.next.next;
        node.next.next.next.next.last.last = node.next.next;
        node.next.next.next.next.last.last.last = node.next;
        node.next.next.next.next.last.last.last.last = node;

        printOutCome(node);

        printOutCome(reverseDouble(node));
    }
}
