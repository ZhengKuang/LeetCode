public class MergeTwoSortedLinkedListAnswer {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode mergeNode(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode cur1 = head1.value < head2.value ? head1 : head2;
        LinkedListNode cur2 = head1.value < head2.value ? head2 : head1;
        LinkedListNode head = head1.value < head2.value ? head1 : head2;
        LinkedListNode last = null;
        LinkedListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                last = cur1;
                cur1 = cur1.next;
            } else {
                last.next = cur2;
                next = cur2.next;
                cur2.next = cur1;
                last = cur2;
                cur2 = next;

            }
        }
        last.next=cur1==null?cur2:cur1;
        return head;
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
