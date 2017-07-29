import java.util.HashMap;

public class DeleteRepetition {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode1(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedListNode last = null;
        LinkedListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur.value)) {
                last.next = cur.next;
            } else {
                map.put(cur.value, 1);
                last=cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static LinkedListNode reverseNode2(LinkedListNode head) {
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
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(2);
        head1.next.next.next = new LinkedListNode(2);
        head1.next.next.next.next = new LinkedListNode(2);
        printOutCome(reverseNode1(head1));
    }
}
