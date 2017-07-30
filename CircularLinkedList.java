public class CircularLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode insertNumber(LinkedListNode head, int num) {
        LinkedListNode newhead = head;
        LinkedListNode cur = head;
        LinkedListNode mynode = new LinkedListNode(num);
        if (cur == null) {
            head = mynode;
            head.next = head;
            return head;
        }
        if (cur.next == cur) {
            cur.next = mynode;
            mynode.next = cur;
            newhead = cur.value <= num ? cur : mynode;
            return newhead;
        }
        while (cur.next != head) {
            LinkedListNode next = cur.next;
            if (cur.value < num && num <= next.value) {
                cur.next = mynode;
                mynode.next = next;
                return head;
            }
            cur = cur.next;
        }
        cur.next=mynode;
        mynode.next=head;
        return mynode;
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
