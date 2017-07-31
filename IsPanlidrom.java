import sun.awt.image.ImageWatched;

public class IsPanlidrom {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPanlindrome(LinkedListNode head) {
        LinkedListNode sp = head;
        LinkedListNode fp = head;
        boolean isPanlindrome = true;
        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        fp = sp.next;
        LinkedListNode pre = sp;
        LinkedListNode next = null;
        while (fp != null) {
            next = fp.next;
            fp.next = pre;
            pre = fp;
            fp = next;
        }
        sp.next = null;
        LinkedListNode cur = head;
        LinkedListNode end = pre;
        while (cur != null) {
            if (cur.value != end.value) {
                isPanlindrome = false;
            }
            end = end.next;
            cur = cur.next;

        }
        fp = pre.next;
        pre.next = null;
        while (fp != null) {
            next = fp.next;
            fp.next = pre;
            pre = fp;
            fp = next;
        }
        return isPanlindrome;
    }


    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(3);
        head1.next.next.next.next = new LinkedListNode(2);
        head1.next.next.next.next.next = new LinkedListNode(0);

        System.out.println(isPanlindrome(head1));
    }
}
