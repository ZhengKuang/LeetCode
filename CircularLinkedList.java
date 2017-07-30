public class CircularLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode insertNumber(LinkedListNode head, int num) {
        LinkedListNode cur = head;
        LinkedListNode mynode = new LinkedListNode(num);
        if (cur == null) {
            head = mynode;
            head.next = head;
            return head;
        }
        LinkedListNode pre=head;
        cur=head.next;
        while (cur != head) {
            if (pre.value < num && num <= cur.value) {
                break;
            }
            pre=cur;
            cur = cur.next;
        }
        pre.next=mynode;
        mynode.next=cur;
        return head.value<num?head:mynode;
    }


    public static void printOutCome(LinkedListNode node) {
        LinkedListNode head = node;
        while (node != null) {
            System.out.println(node.value);
            if (node.next == head) {
                break;
            }
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = null;
        LinkedListNode head = insertNumber(head1, 1);
        printOutCome(head);
        System.out.println("==========");
        head = insertNumber(head, 3);
        printOutCome(head);
        System.out.println("==========");
        head = insertNumber(head, 2);
        printOutCome(head);
        System.out.println("==========");
        head = insertNumber(head, -1);
        printOutCome(head);
        System.out.println("==========");
    }
}
