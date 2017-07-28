public class ReverseLinkedListFromNtoM {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode(LinkedListNode head, int n, int m) {
        if (head == null || head.next == null || n > m) {
            return head;
        }
        LinkedListNode cur = head;
        LinkedListNode last = null;
        LinkedListNode tmp = null;
        LinkedListNode header = null;
        LinkedListNode footer = null;
        int index = 1;
        if (n != 1) {
            while ((index + 1) != n) {
                cur = cur.next;
                index = index + 1;
            }
            header = cur;
            cur = cur.next;
            index++;
            while (index != m + 1) {
                tmp = cur.next;
                cur.next = last;
                last = cur;
                cur = tmp;
                index++;
            }
            footer = tmp;
            header.next.next = footer;
            header.next = last;
            return head;
        } else {
            header = head;
            while (index != m + 1) {
                tmp = cur.next;
                cur.next = last;
                last = cur;
                cur = tmp;
                index++;
            }
            header.next = tmp;
            return last;
        }
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
        printOutCome(reverseNode(head1, 1, 5));
    }
}
