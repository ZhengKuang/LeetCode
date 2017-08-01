public class RandomList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public LinkedListNode random;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode copyList(LinkedListNode head) {
        LinkedListNode cur = head;
        LinkedListNode newhead;
        while (cur != null) {
            LinkedListNode nextCopy =new LinkedListNode(cur.value);
            nextCopy.next = cur.next;
            cur.next = nextCopy;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random==null?null:cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        newhead = cur.next;
        while (cur != null) {
            LinkedListNode nextGroup = cur.next.next;
            cur.next.next = nextGroup == null ? null : nextGroup.next;
            cur.next = nextGroup;
            cur = nextGroup;
        }
        return newhead;
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
        head1.next.next.random = null;
        head1.random = head1.next.next;
        head1.next.random = head1;

        printOutCome(copyList(head1));

    }
}
