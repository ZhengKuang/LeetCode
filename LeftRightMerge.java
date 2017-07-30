public class LeftRightMerge {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode mergeLeftRight(LinkedListNode head) {
        LinkedListNode sp = head;
        LinkedListNode cur = head;
        LinkedListNode end = null;
        while (cur != null) {
            cur = cur.next;
            if (cur == null) break;
            cur = cur.next;
            sp = sp.next;
        }
        end = sp;
        cur = head;
        LinkedListNode lnext = null;
        LinkedListNode rnext = null;
        while (cur.next != end) {
            lnext = cur.next;
            rnext = sp.next;
            cur.next = sp;
            sp.next = lnext;
            sp = rnext;
            cur = lnext;
        }
        cur.next=sp;
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
     //   head1.next.next.next.next = new LinkedListNode(9);
     //   head1.next.next.next.next.next = new LinkedListNode(2);
     //   head1.next.next.next.next.next.next = new LinkedListNode(3);
     //   head1.next.next.next.next.next.next.next = new LinkedListNode(7);
        printOutCome(mergeLeftRight(head1));
    }
}
