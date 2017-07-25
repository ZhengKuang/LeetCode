public class CommonPartLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void printCommonPart(LinkedListNode node1, LinkedListNode node2) {
        while (node1 != null || node2 != null) {
            if (node1.value < node2.value) {
                node1 = node1.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
                System.out.println("Comman Part: " + node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }
        }

    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(4);
        head1.next.next.next = new LinkedListNode(5);
        head1.next.next.next.next = new LinkedListNode(8);

        LinkedListNode head2 = new LinkedListNode(2);
        head2.next = new LinkedListNode(3);
        head2.next.next = new LinkedListNode(4);
        head2.next.next.next = new LinkedListNode(6);
        head2.next.next.next.next = new LinkedListNode(8);

        printCommonPart(head1,head2);
    }
}
